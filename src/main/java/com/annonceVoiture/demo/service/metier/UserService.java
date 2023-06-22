package com.annonceVoiture.demo.service.metier;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.annonceVoiture.demo.app.Achat;
import com.annonceVoiture.demo.app.Vente;
import com.annonceVoiture.demo.entity.Annonces;
import com.annonceVoiture.demo.entity.Users;

public interface UserService{

	ResponseEntity<String> createUsers(Users users);
	ResponseEntity<String> updateUsers(Users users, Long idUser);
	List<Users> getAll();
	Users getUsers(Long idUsers);
	String deleteUsers(Long idUsers);
	String deleteAnnoces(Long idAnnonces);
	List<Users> findBynom(String nom);
	List<Users> findByLocalisation(String localisation);
	List<Annonces> findByPrix(float prix);
	List<Annonces> findByTitre(String titre);
    List<Annonces> findByDescriptionAnnonce(String description);
    List<Annonces> findByTypeVoitureAnnonce(String typeVoiture);
    List<Annonces> findByMarqueAnnonce(String marque);
    List<Achat> findByPrixAchat(float prix);
	List<Vente> findByPrixVente(float prix);
}
