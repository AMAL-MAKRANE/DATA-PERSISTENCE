package jpa.ficheIncident.dao;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* A AgentDeclarant.
*/
@Entity
@Table(name = "AgentDeclarant")
public class AgentDeclarant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "matricule", nullable = false)
	private String matricule;
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "prenom", nullable = false)
	private String prenom;
	
	@OneToMany(targetEntity = FicheIncident.class, mappedBy = "agentDeclarant")
	private List<FicheIncident> fichesIncidentsDeclarees;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<FicheIncident> getFichesIncidentsDeclarees() {
		return fichesIncidentsDeclarees;
	}

	public void setFichesIncidentsDeclarees(List<FicheIncident> fichesIncidentsDeclarees) {
		this.fichesIncidentsDeclarees = fichesIncidentsDeclarees;
	}
	

}