package com.annonceVoiture.demo.service.metier;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.annonceVoiture.demo.entity.Annonces;

public interface AnnonceService {

	ResponseEntity<String> createAnnonce(Annonces annonce);
	ResponseEntity<String> updateAnnonce(Annonces annonce, Long idAnnonce);
	List<Annonces> getAll();
	Annonces findByIdAnnonces(Long idAnnonce);
	String deleteAnnonce(Long idAnnonce);
	List<Annonces> findByTitre(String titre);
	List<Annonces> findByPrix(float prix);
    List<Annonces> findByDescription(String description);
    List<Annonces> findByTypeVoiture(String typeVoiture);
    List<Annonces> findByMarque(String marque);
}