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
import com.annonceVoiture.demo.entity.Users;
import com.annonceVoiture.demo.service.metier.AnnonceService;
import com.annonceVoiture.demo.service.metier.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/User")
public class UserController {

	@Autowired
    UserService userService;
	@Autowired
    AnnonceService annonceService;
	
	@PostMapping(path = "/create")
    public ResponseEntity<String> createUsers(@RequestBody Users users){
        return userService.createUsers(users);
    }
	 @PutMapping(path = "/update/{id}")
	    public ResponseEntity<String> updateUsers(@RequestBody Users users, @PathVariable Long id){
	        return userService.updateUsers(users, id);
	    }
	  @DeleteMapping(path = "/delete/{id}")
	    public String deleteUsers(@PathVariable Long id){
	        return userService.deleteUsers(id);
	    }
	   @GetMapping(path = "/read")
	    public List<Users> readAllUsers(){
	        return userService.getAll();
	    }
	   @GetMapping("/read/nom/{nom}")
	    public List<Users> getByNom(@PathVariable String nom) {
	        return userService.findBynom(nom);
	    }
	   @GetMapping("/read/localisation/{localisation}")
	    public List<Users> getByUsers(@PathVariable String localisation) {
	        return userService.findByLocalisation(localisation);
	    }
	   @GetMapping("/read/description/{description}")
	    public List<Annonces> getBydescription(@PathVariable String description) {
	        return annonceService.findByDescription(description);
	    }
	   @DeleteMapping(path = "/delete/Annonce/{id}")
	    public String deleteAnnonce(@PathVariable Long id){
	        return annonceService.deleteAnnonce(id);
	    }
	   @GetMapping(path = "/read/Annonce")
	    public List<Annonces> readAllAnnonce(){
	        return annonceService.getAll();
	    }
	   @GetMapping(path = "/read/Annonce/titre/{titre}")
	    public List<Annonces> readAllUsersAnnonce(String titre){
	        return annonceService.findByTitre(titre);
	    }
	   @GetMapping("/read/Annonce/typeVoiture/{typeVoiture}")
	    public List<Annonces> getByTypeVoiture(@PathVariable String typeVoiture) {
	        return annonceService.findByTypeVoiture(typeVoiture);
	    }
	   @GetMapping("/read/Annonce/marque/{marque}")
	    public List<Annonces> getByMarque(@PathVariable String marque) {
	        return annonceService.findByMarque(marque);
	    }
	   @GetMapping("/read/Annonce/prix/{prix}")
	    public List<Annonces> getByPrix(@PathVariable float prix) {
	        return annonceService.findByPrix(prix);
	    }
}
