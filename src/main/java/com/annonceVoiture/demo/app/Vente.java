package com.annonceVoiture.demo.app;

import java.util.ArrayList;
import java.util.List;

import com.annonceVoiture.demo.entity.Annonces;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table(name = "Vente")
@Entity(name = "Vente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vente {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idVente;

	    @Column(length = 100, nullable = false)
	    private String nomClient;

	    @Column(length = 15, nullable = false)
	    private Long numTel;

	    @Column(length = 100, nullable = false)
	    private String mail;

	    @Column(length = 100, nullable = false)
	    private float prix;
	    @Column(length = 100, nullable = false)
	    private String marque;
	    @Column(length = 100, nullable = false)
	    private String typeVoiture;
	    @OneToMany(cascade = CascadeType.ALL)
	    List<Annonces> annonces = new ArrayList<>();
		public Vente() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Vente(String nomClient, Long numTel, String mail, float prix, String marque, String typeVoiture) {
			super();
			this.nomClient = nomClient;
			this.numTel = numTel;
			this.mail = mail;
			this.prix = prix;
			this.marque = marque;
			this.typeVoiture = typeVoiture;
		}
		public Long getIdVente() {
			return idVente;
		}
		public void setIdVente(Long idVente) {
			this.idVente = idVente;
		}
		public String getNomClient() {
			return nomClient;
		}
		public void setNomClient(String nomClient) {
			this.nomClient = nomClient;
		}
		public Long getNumTel() {
			return numTel;
		}
		public void setNumTel(Long numTel) {
			this.numTel = numTel;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public float getPrix() {
			return prix;
		}
		public void setPrix(float prix) {
			this.prix = prix;
		}
		public String getMarque() {
			return marque;
		}
		public void setMarque(String marque) {
			this.marque = marque;
		}
		public String getTypeVoiture() {
			return typeVoiture;
		}
		public void setTypeVoiture(String typeVoiture) {
			this.typeVoiture = typeVoiture;
		}
		public List<Annonces> getAnnonces() {
			return annonces;
		}
		public void setAnnonces(List<Annonces> annonces) {
			this.annonces = annonces;
		}
		@Override
		public String toString() {
			return "Vente [idVente=" + idVente + ", nomClient=" + nomClient + ", numTel=" + numTel + ", mail=" + mail
					+ ", prix=" + prix + ", marque=" + marque + ", typeVoiture=" + typeVoiture + ", annonces="
					+ annonces + "]";
		}
	    
}
