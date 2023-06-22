package com.annonceVoiture.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonceVoiture.demo.entity.Annonces;
import com.annonceVoiture.demo.service.metier.AnnonceService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Annonce")
public class AnnonceController {

	@Autowired
    AnnonceService annonceService;
	
	@PostMapping(path = "/create")
    public ResponseEntity<String> creatAnnonce(@RequestBody Annonces annonce){
        return annonceService.createAnnonce(annonce);
    }
	 @PutMapping(path = "/update/{id}")
	    public ResponseEntity<String> updateAnnonce(@RequestBody Annonces annonce, @PathVariable Long id){
	        return annonceService.updateAnnonce(annonce, id);
	    }
	  @DeleteMapping(path = "/delete/{id}")
	    public String deleteAnnonce(@PathVariable Long id){
	        return annonceService.deleteAnnonce(id);
	    }
	   @GetMapping(path = "/read")
	    public List<Annonces> readAllAnnonce(){
	        return annonceService.getAll();
	    }
	   @GetMapping("/read/titre/{titre}")
	    public List<Annonces> getProjetByTitre(@PathVariable String titre) {
	        return annonceService.findByTitre(titre);
	    }
	   @GetMapping("/read/prix/{prix}")
	    public List<Annonces> getProjetByPrix(@PathVariable float prix) {
	        return annonceService.findByPrix(prix);
	    }
	   @GetMapping("/read/description/{description}")
	    public List<Annonces> getProjetBydescription(@PathVariable String description) {
	        return annonceService.findByDescription(description);
	    }
	   @GetMapping("/read/typeVoiture/{typeVoiture}")
	    public List<Annonces> getProjetByTypeVoiture(@PathVariable String typeVoiture) {
	        return annonceService.findByTypeVoiture(typeVoiture);
	    }
	   @GetMapping("/read/marque/{marque}")
	    public List<Annonces> getProjetByMarque(@PathVariable String marque) {
	        return annonceService.findByMarque(marque);
	    }
}
