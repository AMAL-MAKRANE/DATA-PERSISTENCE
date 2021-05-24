package jpa.ficheIncident.dao;
import java.util.List;

public interface FicheIncidentDao {
	
	void insererFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage);
	List<FicheIncident> rechercherTousLesFicheIncidentVoyages();
	FicheIncident rechercherFicheIncidentVoyageParId(Long _id);
	void modifierFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage);
	void supprimerFicheIncidentVoyageParId(FicheIncident _ficheIncidentVoyage);
	
	List<FicheIncident> listeFichesMarrakech();
	List<FicheIncident> listeIncidentsCritiques();
	List<Object[]> NombreIncidentsParLieu();
	List<Object[]> NombreIncidentsParAgent();
	List<Object[]> vehiculeCritique();
	List<Object[]> nombreIncidentCritiqueParVehicule();
	List<Object[]> incidentTrieParDureeDesc();
	List<FicheIncident> listeIncidentRecent();
	List<FicheIncident> listeLesPlusRecentIncidentAccident();
	List<Object[]> frequenceIncident();
	List<Object[]> classementChauffeurs();
	List<Object[]> chauffeurAucunIncident();
	List<Object[]> tempsAttenteMaximum();
	
	
	
}