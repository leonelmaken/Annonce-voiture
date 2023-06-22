package com.annonceVoiture.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annonceVoiture.demo.app.Achat;

public interface AchatRepository extends JpaRepository<Achat, Long>{

	@Query("select a from Achat a where a.nomVendeur like %?1%")
	List<Achat> findBynom(String nomVendeur);
	List<Achat> findByPrix(float prix);
}
