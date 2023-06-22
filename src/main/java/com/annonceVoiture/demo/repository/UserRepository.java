package com.annonceVoiture.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.annonceVoiture.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	/*
	 * l'annotation @Query permet de spécifier le fonctionnement de la recherche pour pouvoir fonctionner avec les mots clés.
	 */
	@Query("select u from Users u where u.nom like %?1%")
	List<Users> findBynom(String nom);
	@Query("select u from Users u where concat(u.numTel, u.numTel) like %?1%")
	List<Users> findByNumTel(Long numTel);
	@Query("select u from Users u where u.localisation like %?1%")
	List<Users> findByLocalisation(String localisation);
}
