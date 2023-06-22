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

import com.annonceVoiture.demo.app.Achat;
import com.annonceVoiture.demo.service.app.AchatService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Achat")
public class AchatController {

	@Autowired
    AchatService achatService;
	
	@PostMapping(path = "/create")
    public ResponseEntity<String> creatAchat(@RequestBody Achat achat){
        return achatService.createAchat(achat);
    }
	 @PutMapping(path = "/update/{id}")
	    public ResponseEntity<String> updateAchat(@RequestBody Achat achat, @PathVariable Long id){
	        return achatService.updateAchat(achat, id);
	    }
	  @DeleteMapping(path = "/delete/{id}")
	    public String deleteAchat(@PathVariable Long id){
	        return achatService.deleteAchat(id);
	    }
	   @GetMapping(path = "/read")
	    public List<Achat> readAllAnnonce(){
	        return achatService.getAll();
	    }
	   @GetMapping("/read/nomVendeur/{nomVendeur}")
	    public List<Achat> getAchatByNomVendeur(@PathVariable String nomVendeur) {
	        return achatService.findBynom(nomVendeur);
	    }
	   @GetMapping("/read/prix/{prix}")
	    public List<Achat> getAchatByPrix(@PathVariable float prix) {
	        return achatService.findByPrix(prix);
	    }
}
