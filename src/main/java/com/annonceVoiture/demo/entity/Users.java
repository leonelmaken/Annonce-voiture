package com.annonceVoiture.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.annonceVoiture.demo.app.Achat;
import com.annonceVoiture.demo.app.Vente;

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

@Table(name = "Users")
@Entity(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idUser;

	    @Column(length = 100, nullable = false)
	    private String nom;

	    @Column(length = 15, nullable = false)
	    private Long numTel;

	    @Column(length = 100, nullable = false)
	    private String mail;

	    @Column(length = 100, nullable = false)
	    private String password;
	    @Column(length = 100, nullable = false)
	    private String localisation;
	    @OneToMany(cascade = CascadeType.ALL)
	    List<Annonces> annonces = new ArrayList<>();
	    @OneToMany(cascade = CascadeType.ALL)
	    List<Vente> vente = new ArrayList<>();
	    @OneToMany(cascade = CascadeType.ALL)
	    List<Achat> achat = new ArrayList<>();
		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Users(String nom, Long numTel, String mail, String password, String localisation) {
			super();
			this.nom = nom;
			this.numTel = numTel;
			this.mail = mail;
			this.password = password;
			this.localisation = localisation;
		}

		public Long getIdUser() {
			return idUser;
		}
		public void setIdUser(Long idUser) {
			this.idUser = idUser;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLocalisation() {
			return localisation;
		}
		public void setLocalisation(String localisation) {
			this.localisation = localisation;
		}

		public List<Vente> getVente() {
			return vente;
		}

		public void setVente(List<Vente> vente) {
			this.vente = vente;
		}

		public List<Annonces> getAnnonces() {
			return annonces;
		}

		public void setAnnonces(List<Annonces> annonces) {
			this.annonces = annonces;
		}

		public List<Achat> getAchat() {
			return achat;
		}

		public void setAchat(List<Achat> achat) {
			this.achat = achat;
		}

		@Override
		public String toString() {
			return "Users [idUser=" + idUser + ", nom=" + nom + ", numTel=" + numTel + ", mail=" + mail + ", password="
					+ password + ", localisation=" + localisation + ", annonces=" + annonces + ", vente=" + vente
					+ ", achat=" + achat + "]";
		}
}
