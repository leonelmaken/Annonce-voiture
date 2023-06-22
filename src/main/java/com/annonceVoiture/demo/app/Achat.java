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
@Table(name = "Achat")
@Entity(name = "Achat")
@Inheritance(strategy = InheritanceType.JOINED)
public class Achat {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idAchat;

	    @Column(length = 100, nullable = false)
	    private String nomVendeur;

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
	    @Column
	    private int quantité;
	    @OneToMany(cascade = CascadeType.ALL)
	    List<Annonces> annonces = new ArrayList<>();
	    
	    
	    
		public Achat() {
			super();
			// TODO Auto-generated constructor stub
		}
		



		
		public Achat(String nomVendeur, Long numTel, String mail, float prix, String marque, String typeVoiture,
				int quantité) {
			super();
			this.nomVendeur = nomVendeur;
			this.numTel = numTel;
			this.mail = mail;
			this.prix = prix;
			this.marque = marque;
			this.typeVoiture = typeVoiture;
			this.quantité = quantité;
		}





		public Long getIdAchat() {
			return idAchat;
		}




		public void setIdAchat(Long idAchat) {
			this.idAchat = idAchat;
		}




		public String getNomVendeur() {
			return nomVendeur;
		}




		public void setNomVendeur(String nomVendeur) {
			this.nomVendeur = nomVendeur;
		}




		public Long getNumTel() {
			return numTel;
		}




		public int getQuantité() {
			return quantité;
		}





		public void setQuantité(int quantité) {
			this.quantité = quantité;
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
			return "Achat [idAchat=" + idAchat + ", nomVendeur=" + nomVendeur + ", numTel=" + numTel + ", mail=" + mail
					+ ", prix=" + prix + ", marque=" + marque + ", typeVoiture=" + typeVoiture + ", quantité="
					+ quantité + ", annonces=" + annonces + "]";
		}
	    
}
