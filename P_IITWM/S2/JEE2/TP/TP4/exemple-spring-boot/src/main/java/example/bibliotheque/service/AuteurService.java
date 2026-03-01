package example.bibliotheque.service;

import example.bibliotheque.entities.Auteur;
import example.bibliotheque.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuteurService {
    @Autowired
    private AuteurRepository auteurRepository;

    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }

    public Auteur saveAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    public void deleteAuteur(Long id) {
        auteurRepository.deleteById(id);
    }

    public Optional<Auteur> getAuteurById(Long id) {
        return auteurRepository.findById(id);
    }
}
