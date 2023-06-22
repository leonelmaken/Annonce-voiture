package com.annonceVoiture.demo.service.app;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.annonceVoiture.demo.app.Vente;

public interface VenteService {
  
	ResponseEntity<String> createVente(Vente vente);
	//ResponseEntity<String> updateAchat(Achat achat, Long idAchat);
	List<Vente> getAll();
	Vente getByIdVente(Long idVente);
	String deleteVente(Long idVente);
	List<Vente> findByPrix(float prix);
}
