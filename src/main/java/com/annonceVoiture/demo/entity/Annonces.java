package com.annonceVoiture.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Table(name = "Annonces")
@Entity(name = "Annonces")
@Inheritance(strategy = InheritanceType.JOINED)
public class Annonces {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idAnnonce;

	    @Column(length = 100, nullable = false)
	    private String titre;

	    @Column(length = 250, nullable = false)
	    private String description;

	    @Column(length = 250, nullable = false)
	    private String image;

	    @Column(length = 100, nullable = false)
	    private String typeVoiture;
	    @Column(length = 100, nullable = false)
	    private String marque;
	    @Column
	    private int prix;
		public Annonces() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Annonces(String titre, String description, String image, String typeVoiture, String marque, int prix) {
			super();
			this.titre = titre;
			this.description = description;
			this.image = image;
			this.typeVoiture = typeVoiture;
			this.marque = marque;
			this.prix = prix;
		}
		public Long getIdAnnonce() {
			return idAnnonce;
		}
		public void setIdAnnonce(Long idAnnonce) {
			this.idAnnonce = idAnnonce;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getTypeVoiture() {
			return typeVoiture;
		}
		public void setTypeVoiture(String typeVoiture) {
			this.typeVoiture = typeVoiture;
		}
		public String getMarque() {
			return marque;
		}
		public void setMarque(String marque) {
			this.marque = marque;
		}
		public int getPrix() {
			return prix;
		}
		public void setPrix(int prix) {
			this.prix = prix;
		}
		@Override
		public String toString() {
			return "Annonces [idAnnonce=" + idAnnonce + ", titre=" + titre + ", description=" + description + ", image="
					+ image + ", typeVoiture=" + typeVoiture + ", marque=" + marque + ", prix=" + prix + "]";
		}
}
