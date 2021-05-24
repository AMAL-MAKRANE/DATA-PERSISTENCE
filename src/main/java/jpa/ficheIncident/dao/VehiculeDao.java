package jpa.ficheIncident.dao;
import java.util.List;
public interface VehiculeDao {
	
	void insererVehicule(String _codeInterne, String _immatriculation, String _dateMiseEnCirculation,boolean _depannage);
	
	void insererVehicule(Vehicule _vehicule);
	
	List<Vehicule> rechercherTousLesVehicules();
	
	Vehicule rechercherVehiculeParId(Long _id);
	
	List<Vehicule> rechercherVehiculeParImmatriculation(String _immatriculation);
	
	void modifierVehiculeCodeInterneParId(Long _id, String _codeInterne);
	
	void supprimerVehiculeParId(Long _id);
	
	void modifierVehiculeCodeInterneParId(Vehicule _vehicule);
	
	void supprimerVehiculeParId(Vehicule _vehicule);

	List<Vehicule> listeVehiculesLesPlusNeufs();
	List<Vehicule> listeVehiculeDepannage();
}