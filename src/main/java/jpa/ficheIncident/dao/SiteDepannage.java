package jpa.ficheIncident.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Site.
 */
@Entity
@Table(name = "SiteDepannage")

public class SiteDepannage implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code", nullable = false)
	private String code ;
	
	@Column(name = "libelle", nullable = false)
	private String libelle;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	public SiteDepannage(){}
	
	public SiteDepannage(String code,String libelle,String description){
		this.code = code;
		this.libelle=libelle;
		this.description=description;
	}

	public Long getId() {
		return id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
