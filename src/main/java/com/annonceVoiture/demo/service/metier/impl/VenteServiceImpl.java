package com.annonceVoiture.demo.service.metier.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.annonceVoiture.demo.app.Vente;
import com.annonceVoiture.demo.service.app.VenteService;

@Service
public class VenteServiceImpl implements VenteService{

	@Override
	public ResponseEntity<String> createVente(Vente vente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vente getByIdVente(Long idVente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteVente(Long idVente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vente> findByPrix(float prix) {
		// TODO Auto-generated method stub
		return null;
	}

}
