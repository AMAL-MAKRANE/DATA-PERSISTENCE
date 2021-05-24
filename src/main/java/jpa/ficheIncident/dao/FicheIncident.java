package jpa.ficheIncident.dao;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.util.Date;

/**
* A FicheIncident.
*/
@Entity
@Table(name = "FicheIncident")
public class FicheIncident implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_incident", nullable = false)
	private Date date_incident;
	
	@Column(name = "numero_fiche", nullable = false)
	private String numero_fiche;
	
	@Column(name = "incident_critique", nullable = false)
	private boolean incident_critique;
	
	@Column(name = "lieu_incident", nullable = false)
	private String lieu_incident;
	
	@Column(name = "nombre_voyageur", nullable = false)
	private Integer nombre_voyageur;
	
	@Column(name = "description_incident", nullable = false)
	private String description_incident;
	
	@Column(name = "type_incident", nullable = false)
	private String type_incident;
	
	@Column(name = "date_declaration", nullable = false)
	private Date date_declaration;
	
	@Column(name = "date_reprise", nullable = false)
	private Date date_reprise;
	@Column(name = "chauffeur_id", nullable = false)
	private int chauffeur_id;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	private AgentDeclarant agentDeclarant;
	
	@ManyToOne
	private Vehicule vehicule;
	private Chauffeur chauffeur;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public int getChaufeur_id() {
		return chauffeur_id;
	}

	public void setChauffeur_id(int chauffeur_id ) {
		this.chauffeur_id = chauffeur_id;
	}
	public Date getDate_incident() {
		return date_incident;
	}

	public void setDate_incident(Date date_incident) {
		this.date_incident = date_incident;
	}

	public String getNumero_fiche() {
		return numero_fiche;
	}

	public void setNumero_fiche(String numero_fiche) {
		this.numero_fiche = numero_fiche;
	}

	public boolean isIncident_critique() {
		return incident_critique;
	}

	public void setIncident_critique(boolean incident_critique) {
		this.incident_critique = incident_critique;
	}

	public String getLieu_incident() {
		return lieu_incident;
	}

	public void setLieu_incident(String lieu_incident) {
		this.lieu_incident = lieu_incident;
	}

	public Integer getNombre_voyageur() {
		return nombre_voyageur;
	}

	public void setNombre_voyageur(Integer nombre_voyageur) {
		this.nombre_voyageur = nombre_voyageur;
	}

	public String getDescription_incident() {
		return description_incident;
	}

	public void setDescription_incident(String description_incident) {
		this.description_incident = description_incident;
	}
	
	public String getType_incident() {
		return type_incident;
	}

	public void setType_incident(String description_incident) {
		this.type_incident = description_incident;
	}
	

	public Date getDate_declaration() {
		return date_declaration;
	}

	public void setDate_declaration(Date date_declaration) {
		this.date_declaration = date_declaration;
	}

	public Date getDate_reprise() {
		return date_reprise;
	}

	public void setDate_reprise(Date date_reprise) {
		this.date_reprise = date_reprise;
	}

	public AgentDeclarant getAgentDeclarant() {
		return agentDeclarant;
	}

	public void setAgentDeclarant(AgentDeclarant agentDeclarant) {
		this.agentDeclarant = agentDeclarant;
	}
	

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Chauffeur getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}
	
	
}