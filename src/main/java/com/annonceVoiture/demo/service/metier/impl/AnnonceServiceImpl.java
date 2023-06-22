package com.annonceVoiture.demo.service.metier.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.annonceVoiture.demo.entity.Annonces;
import com.annonceVoiture.demo.repository.AnnoncesRepository;
import com.annonceVoiture.demo.service.metier.AnnonceService;

@Service
public class AnnonceServiceImpl implements AnnonceService {

	@Autowired
	AnnoncesRepository annoncesRepository;
	
	
	@Override
	public ResponseEntity<String> createAnnonce(Annonces annonce) {
		try {
            if (annonce.getTitre() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer un titre",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le nom est vide

            if (annonce.getDescription() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer une description",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le num tel est vide

            if (annonce.getMarque() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer une marque",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500 si le mail est vide

            if (annonce.getPrix() == 0L)
                return new ResponseEntity<>(
                        "Vous devez entrer un prix",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500 ainsi de suite

            if (annonce.getImage() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer une image",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (annonce.getTypeVoiture() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer un type de voitre",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            annoncesRepository.save(annonce);
            return new ResponseEntity<>(
                    "L'annonce a été enregistrée avec succès avec succès " + annoncesRepository.save(annonce),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

	}

	@Override
	public ResponseEntity<String> updateAnnonce(Annonces annonce, Long idAnnonce) {
		Optional<Annonces> use = annoncesRepository.findById(idAnnonce);
        if(use.isEmpty()) return new ResponseEntity<>(
                "Annonce not found",
                HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

        if (annonce.getTitre() != null || !use.get().getTitre().equals(annonce.getTitre()))
            use.get().setTitre(annonce.getTitre());

        if (annonce.getPrix() != 0L || !(use.get().getPrix()==(annonce.getPrix()))) // 1
            use.get().setPrix((int) annonce.getPrix());

        if (annonce.getDescription() != null || !use.get().getDescription().equals(annonce.getDescription()))
            use.get().setDescription(annonce.getDescription());

        if (annonce.getImage() != null || !use.get().getImage().equals(annonce.getImage()))
            use.get().setImage(annonce.getImage());

        annoncesRepository.save(annonce);
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
	}

	@Override
	public List<Annonces> getAll() {
		// TODO Auto-generated method stub
		return annoncesRepository.findAll();
	}

	@Override
	public Annonces findByIdAnnonces(Long idAnnonce) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAnnonce(Long idAnnonce) {
		// TODO Auto-generated method stub
		 annoncesRepository.deleteById(idAnnonce);
	        return "l'annonce a été supprimé";
	}

	@Override
	public List<Annonces> findByTitre(String titre) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByTitre(titre);
	}

	@Override
	public List<Annonces> findByPrix(float prix) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByPrix(prix);
	}

	@Override
	public List<Annonces> findByDescription(String description) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByDescription(description);
	}

	@Override
	public List<Annonces> findByTypeVoiture(String typeVoiture) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByTypeVoiture(typeVoiture);
	}

	@Override
	public List<Annonces> findByMarque(String marque) {
		// TODO Auto-generated method stub
		return annoncesRepository.findByMarque(marque);
	}

}
