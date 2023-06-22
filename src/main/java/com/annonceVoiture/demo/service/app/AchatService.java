package com.annonceVoiture.demo.service.app;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.annonceVoiture.demo.app.Achat;

public interface AchatService {

	ResponseEntity<String> createAchat(Achat achat);
	ResponseEntity<String> updateAchat(Achat achat, Long idAchat);
	List<Achat> getAll();
	List<Achat> findBynom(String nomVendeur);
	Achat getAchat(Long idAchat);
	String deleteAchat(Long idAchat);
	List<Achat> findByPrix(float prix);
}
