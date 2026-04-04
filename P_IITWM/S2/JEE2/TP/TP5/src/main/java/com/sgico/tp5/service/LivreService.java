package com.sgico.tp5.service;

import com.sgico.tp5.dto.livre.LivreRequest;
import com.sgico.tp5.dto.livre.LivreResponse;
import com.sgico.tp5.entity.Livre;
import com.sgico.tp5.exception.BusinessException;
import com.sgico.tp5.exception.ResourceNotFoundException;
import com.sgico.tp5.repository.LivreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Transactional(readOnly = true)
    public List<LivreResponse> findAll() {
        return livreRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public LivreResponse findById(Long id) {
        return toResponse(getEntityById(id));
    }

    @Transactional
    public LivreResponse create(LivreRequest request) {
        ensureIsbnUnique(request.getIsbn(), null);

        Livre livre = new Livre();
        livre.setTitre(request.getTitre());
        livre.setAuteur(request.getAuteur());
        livre.setIsbn(request.getIsbn());
        livre.setDisponible(request.getDisponible() == null || request.getDisponible());

        return toResponse(livreRepository.save(livre));
    }

    @Transactional
    public LivreResponse update(Long id, LivreRequest request) {
        Livre livre = getEntityById(id);
        ensureIsbnUnique(request.getIsbn(), id);

        livre.setTitre(request.getTitre());
        livre.setAuteur(request.getAuteur());
        livre.setIsbn(request.getIsbn());
        if (request.getDisponible() != null) {
            livre.setDisponible(request.getDisponible());
        }

        return toResponse(livreRepository.save(livre));
    }

    @Transactional
    public void delete(Long id) {
        Livre livre = getEntityById(id);
        livreRepository.delete(livre);
    }

    @Transactional(readOnly = true)
    public Livre getEntityById(Long id) {
        return livreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livre introuvable avec l'id " + id));
    }

    private void ensureIsbnUnique(String isbn, Long currentId) {
        livreRepository.findByIsbn(isbn).ifPresent(existing -> {
            if (currentId == null || !existing.getId().equals(currentId)) {
                throw new BusinessException("Un livre avec cet ISBN existe deja");
            }
        });
    }

    private LivreResponse toResponse(Livre livre) {
        LivreResponse response = new LivreResponse();
        response.setId(livre.getId());
        response.setTitre(livre.getTitre());
        response.setAuteur(livre.getAuteur());
        response.setIsbn(livre.getIsbn());
        response.setDisponible(livre.isDisponible());
        return response;
    }
}

