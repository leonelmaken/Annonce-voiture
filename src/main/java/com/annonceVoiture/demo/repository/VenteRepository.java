package com.annonceVoiture.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonceVoiture.demo.app.Vente;

public interface VenteRepository extends JpaRepository<Vente, Long>{

	List<Vente> findByPrix(float prix);
	Vente getByIdVente(Long idVente);
}
