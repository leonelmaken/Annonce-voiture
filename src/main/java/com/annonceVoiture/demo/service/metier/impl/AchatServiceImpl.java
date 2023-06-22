package com.annonceVoiture.demo.service.metier.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.annonceVoiture.demo.app.Achat;
import com.annonceVoiture.demo.repository.AchatRepository;
import com.annonceVoiture.demo.service.app.AchatService;

@Service
public class AchatServiceImpl implements AchatService{

	  @Autowired
	  AchatRepository achatRepository;
	
	@Override
	public ResponseEntity<String> createAchat(Achat achat) {
		try {
            if (achat.getMail() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre mail",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le nom est vide
            
            if (achat.getNomVendeur() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer le nom d'un vendeur",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le nom est vide
            if (achat.getTypeVoiture() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer un type de voidure",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le nom est vide

            
            if (achat.getNumTel() == 0) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre numero de telephone",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (achat.getPrix() == 0L) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer un prix",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (achat.getQuantité() == 0)
                return new ResponseEntity<>(
                        "Vous devez entrer une quantité",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            achatRepository.save(achat);
            return new ResponseEntity<>(
                    "L'achat a été enregistrée avec succès avec succès " + achatRepository.save(achat),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@Override
	public ResponseEntity<String> updateAchat(Achat achat, Long idAchat) {
		Optional<Achat> use = achatRepository.findById(idAchat);
        if(use.isEmpty()) return new ResponseEntity<>(
                "Achat not found",
                HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

        if (achat.getMail() != null || !use.get().getMail().equals(achat.getMail()))
            use.get().setMail(achat.getMail());

        if (achat.getNumTel() != 0L || !(use.get().getNumTel().equals(achat.getNumTel()))) // 1
            use.get().setNumTel(achat.getNumTel());

        if (achat.getMarque() != null || !use.get().getMarque().equals(achat.getMarque()))
            use.get().setMarque(achat.getMarque());

        if (achat.getNomVendeur() != null || !use.get().getNomVendeur().equals(achat.getNomVendeur()))
            use.get().setNomVendeur(achat.getNomVendeur());
        if (achat.getPrix() != 0L || !(use.get().getPrix() == (achat.getPrix()))) // 1
            use.get().setPrix(achat.getPrix());

        achatRepository.save(achat);
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
	}

	@Override
	public List<Achat> getAll() {
		// TODO Auto-generated method stub
		return achatRepository.findAll();
	}

	@Override
	public Achat getAchat(Long idAchat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAchat(Long idAchat) {
		 achatRepository.deleteById(idAchat);;
	        return "l'achat a été supprimé";
	}

	@Override
	public List<Achat> findByPrix(float prix) {
		// TODO Auto-generated method stub
		return achatRepository.findByPrix(prix);
	}

	@Override
	public List<Achat> findBynom(String nomVendeur) {
		// TODO Auto-generated method stub
		return achatRepository.findBynom(nomVendeur);
		
	}

}
