package jpa.ficheIncident.dao;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
* CREATION DES COLONNES DU CLASSE VEHICULE ET LEURS SETEURS ET GETEURS 
*/
@Entity
@Table(name = "Vehicule")
public class Vehicule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code_interne", nullable = false)
	private String codeInterne;
	
	@Column(name = "immatriculation", nullable = false)
	private String immatriculation;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateMiseEnCirculation")
	private Date dateMiseEnCirculation;
	
	@ManyToMany(targetEntity = Chauffeur.class)
	@JoinTable(name = "vehicules_chauffeurs")
	private List<Chauffeur> chauffeurs;
	
	@Column(name = "depannage" ,columnDefinition = "boolean default false", nullable = false)
	private Boolean depannage;
	
	
	public Boolean getDepannage() {
		return depannage;
	}
	public void setDepannage(Boolean depannage) {
		this.depannage = depannage;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeInterne() {
		return codeInterne;
	}

	public void setCodeInterne(String codeInterne) {
		if (this.depannage=false) {
			if (codeInterne.indexOf("DEP")==0) this.codeInterne=codeInterne;
			else System.out.println("le code interne fourni ne correspond pas "
					+ "à un code Interne d'un véhicule de dépannage");
		}
		else this.codeInterne = codeInterne;
		
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Date getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}

	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

	public List<Chauffeur> getChauffeurs() {
		return chauffeurs;
	}

	public void setChauffeurs(List<Chauffeur> chauffeurs) {
		this.chauffeurs = chauffeurs;
	}
	
	

	
}