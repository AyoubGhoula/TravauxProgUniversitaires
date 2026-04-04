package com.sgico.tp5.service;

import com.sgico.tp5.dto.emprunte.EmprunteRequest;
import com.sgico.tp5.dto.emprunte.EmprunteResponse;
import com.sgico.tp5.dto.emprunte.RetourRequest;
import com.sgico.tp5.entity.Emprunte;
import com.sgico.tp5.entity.Livre;
import com.sgico.tp5.entity.Membre;
import com.sgico.tp5.exception.BusinessException;
import com.sgico.tp5.exception.ResourceNotFoundException;
import com.sgico.tp5.repository.EmprunteRepository;
import com.sgico.tp5.repository.LivreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprunteService {

    private final EmprunteRepository emprunteRepository;
    private final LivreRepository livreRepository;
    private final LivreService livreService;
    private final MembreService membreService;

    public EmprunteService(
            EmprunteRepository emprunteRepository,
            LivreRepository livreRepository,
            LivreService livreService,
            MembreService membreService
    ) {
        this.emprunteRepository = emprunteRepository;
        this.livreRepository = livreRepository;
        this.livreService = livreService;
        this.membreService = membreService;
    }

    @Transactional(readOnly = true)
    public List<EmprunteResponse> findAll() {
        return emprunteRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public EmprunteResponse findById(Long id) {
        return toResponse(getEntityById(id));
    }

    @Transactional
    public EmprunteResponse createEmprunt(EmprunteRequest request) {
        Livre livre = livreService.getEntityById(request.getLivreId());
        Membre membre = membreService.getEntityById(request.getMembreId());

        if (!livre.isDisponible()) {
            throw new BusinessException("Ce livre n'est pas disponible pour emprunt");
        }

        Emprunte emprunte = new Emprunte();
        emprunte.setLivre(livre);
        emprunte.setMembre(membre);
        emprunte.setDateEmprunt(request.getDateEmprunt() != null ? request.getDateEmprunt() : LocalDate.now());
        emprunte.setDateRetour(null);

        livre.setDisponible(false);
        livreRepository.save(livre);

        return toResponse(emprunteRepository.save(emprunte));
    }

    @Transactional
    public EmprunteResponse retournerLivre(Long emprunteId, RetourRequest request) {
        Emprunte emprunte = getEntityById(emprunteId);

        if (emprunte.getDateRetour() != null) {
            throw new BusinessException("Cet emprunt est deja cloture");
        }

        LocalDate dateRetour = request != null && request.getDateRetour() != null
                ? request.getDateRetour()
                : LocalDate.now();

        if (dateRetour.isBefore(emprunte.getDateEmprunt())) {
            throw new BusinessException("La date de retour ne peut pas preceder la date d'emprunt");
        }

        emprunte.setDateRetour(dateRetour);

        Livre livre = emprunte.getLivre();
        livre.setDisponible(true);
        livreRepository.save(livre);

        return toResponse(emprunteRepository.save(emprunte));
    }

    @Transactional(readOnly = true)
    public Emprunte getEntityById(Long id) {
        return emprunteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emprunt introuvable avec l'id " + id));
    }

    private EmprunteResponse toResponse(Emprunte emprunte) {
        EmprunteResponse response = new EmprunteResponse();
        response.setId(emprunte.getId());
        response.setDateEmprunt(emprunte.getDateEmprunt());
        response.setDateRetour(emprunte.getDateRetour());
        response.setLivreId(emprunte.getLivre().getId());
        response.setLivreTitre(emprunte.getLivre().getTitre());
        response.setMembreId(emprunte.getMembre().getId());
        response.setMembreNomPrenom(emprunte.getMembre().getNomPrenom());
        return response;
    }
}

