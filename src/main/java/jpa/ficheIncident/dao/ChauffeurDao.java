package jpa.ficheIncident.dao;

import java.util.List;

public interface ChauffeurDao {
	void insererChauffeur(Chauffeur _Chauffeur);
	List<Chauffeur> rechercherTousLesChauffeurs();
	Chauffeur rechercherChauffeurParId(Long _id);
	void modifierChauffeur(Chauffeur _Chauffeur);
	void supprimerChauffeur(Chauffeur _Chauffeur);
}