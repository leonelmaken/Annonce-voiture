package com.annonceVoiture.demo.service.metier.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.annonceVoiture.demo.app.Achat;
import com.annonceVoiture.demo.app.Vente;
import com.annonceVoiture.demo.entity.Annonces;
import com.annonceVoiture.demo.entity.Users;
import com.annonceVoiture.demo.repository.AchatRepository;
import com.annonceVoiture.demo.repository.AnnoncesRepository;
import com.annonceVoiture.demo.repository.UserRepository;
import com.annonceVoiture.demo.repository.VenteRepository;
import com.annonceVoiture.demo.service.metier.UserService;

@Service
public class UserServiceImpl implements UserService {

	  @Autowired
	  UserRepository userRepository;
	  
	  
	  @Autowired
	  AnnoncesRepository annoncesRepository;
	  
	  @Autowired
	  AchatRepository achatRepository;
	  
	  @Autowired
	  VenteRepository venteRepository;
	  
	@Override
	public ResponseEntity<String> createUsers(Users users) {
		try {
            if (users.getNom() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre nom",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le nom est vide
            
            if (users.getMail() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre mail",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500 si le mail est vide

            if (users.getPassword() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer un password",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500 ainsi de suite

            if (users.getLocalisation() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre localisation",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (users.getNumTel() == 0) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre numero de telephone",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            userRepository.save(users);
            return new ResponseEntity<>(
                    "Vous avez été enregistré avec succès " + userRepository.save(users),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

	}

	@Override
	public ResponseEntity<String> updateUsers(Users users, Long idUser) {
		  Optional<Users> use = userRepository.findById(idUser);
	        if(use.isEmpty()) return new ResponseEntity<>(
	                "Users not found",
	                HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

	        if (users.getNom() != null || !use.get().getNom().equals(users.getNom()))
	            use.get().setNom(users.getNom());

	        if (users.getNumTel() != 0L || !(use.get().getNumTel().equals(users.getNumTel()))) // 1
	            use.get().setNumTel(users.getNumTel());

	        if (users.getMail() != null || !use.get().getMail().equals(users.getMail()))
	            use.get().setMail(users.getMail());

	        if (users.getPassword() != null || !use.get().getPassword().equals(users.getPassword()))
	            use.get().setPassword(users.getPassword());

	        userRepository.save(users);
	        return new ResponseEntity<>(
	                "Modification reussie" ,
	                HttpStatus.OK);
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Users getUsers(Long idUsers) {
		  if (userRepository.findById(idUsers).isPresent())
	            return userRepository.findById(idUsers).get();
	        else return null;
	}

	@Override
	public String deleteUsers(Long idUsers) {
		// TODO Auto-generated method stub
		 userRepository.deleteById(idUsers);
	        return "l'user a été supprimé";
	}

	@Override
	public String deleteAnnoces(Long idAnnonces) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findBynom(String nom) {
		return userRepository.findBynom(nom);
	}

	@Override
	public List<Users> findByLocalisation(String localisation) {
		// TODO Auto-generated method stub
		return userRepository.findByLocalisation(localisation);
	}

	@Override
	public List<Annonces> findByPrix(float prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Annonces> findByTitre(String titre) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByTitre(titre);
	}

	@Override
	public List<Annonces> findByDescriptionAnnonce(String description) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByDescription(description);
	}

	@Override
	public List<Annonces> findByTypeVoitureAnnonce(String typeVoiture) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByTypeVoiture(typeVoiture);
	}

	@Override
	public List<Annonces> findByMarqueAnnonce(String marque) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByMarque(marque);
	}

	@Override
	public List<Achat> findByPrixAchat(float prix) {
		// TODO Auto-generated method stub
		return achatRepository.findByPrix(prix);
	}

	@Override
	public List<Vente> findByPrixVente(float prix) {
		// TODO Auto-generated method stub
		return venteRepository.findByPrix(prix);
	}

}
