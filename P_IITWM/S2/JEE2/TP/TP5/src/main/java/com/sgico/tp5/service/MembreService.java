package com.sgico.tp5.service;

import com.sgico.tp5.dto.membre.MembreRequest;
import com.sgico.tp5.dto.membre.MembreResponse;
import com.sgico.tp5.entity.Membre;
import com.sgico.tp5.exception.BusinessException;
import com.sgico.tp5.exception.ResourceNotFoundException;
import com.sgico.tp5.repository.MembreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembreService {

    private final MembreRepository membreRepository;

    public MembreService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    @Transactional(readOnly = true)
    public List<MembreResponse> findAll() {
        return membreRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public MembreResponse findById(Long id) {
        return toResponse(getEntityById(id));
    }

    @Transactional
    public MembreResponse create(MembreRequest request) {
        ensureEmailUnique(request.getEmail(), null);

        Membre membre = new Membre();
        membre.setNomPrenom(request.getNomPrenom());
        membre.setEmail(request.getEmail());

        return toResponse(membreRepository.save(membre));
    }

    @Transactional
    public MembreResponse update(Long id, MembreRequest request) {
        Membre membre = getEntityById(id);
        ensureEmailUnique(request.getEmail(), id);

        membre.setNomPrenom(request.getNomPrenom());
        membre.setEmail(request.getEmail());

        return toResponse(membreRepository.save(membre));
    }

    @Transactional
    public void delete(Long id) {
        Membre membre = getEntityById(id);
        membreRepository.delete(membre);
    }

    @Transactional(readOnly = true)
    public Membre getEntityById(Long id) {
        return membreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Membre introuvable avec l'id " + id));
    }

    private void ensureEmailUnique(String email, Long currentId) {
        membreRepository.findByEmail(email).ifPresent(existing -> {
            if (currentId == null || !existing.getId().equals(currentId)) {
                throw new BusinessException("Un membre avec cet email existe deja");
            }
        });
    }

    private MembreResponse toResponse(Membre membre) {
        MembreResponse response = new MembreResponse();
        response.setId(membre.getId());
        response.setNomPrenom(membre.getNomPrenom());
        response.setEmail(membre.getEmail());
        return response;
    }
}

