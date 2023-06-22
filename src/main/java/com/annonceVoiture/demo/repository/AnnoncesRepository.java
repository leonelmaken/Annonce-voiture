package com.annonceVoiture.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annonceVoiture.demo.entity.Annonces;
import com.annonceVoiture.demo.entity.Users;

public interface AnnoncesRepository extends JpaRepository<Annonces, Long> {

	@Query("select a from Annonces a where a.titre like %?1%")
	List<Annonces> findByTitre(String titre);
	List<Annonces> findByPrix(float prix);
	@Query("select a from Annonces a where a.description like %?1%")
	List<Annonces> findByDescription(String description);
	@Query("select a from Annonces a where a.typeVoiture like %?1%")
	List<Annonces> findByTypeVoiture(String typeVoiture);
	@Query("select a from Annonces a where a.marque like %?1%")
	List<Annonces> findByMarque(String marque);
}
