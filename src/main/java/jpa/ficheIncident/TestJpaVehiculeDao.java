package jpa.ficheIncident;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import jpa.ficheIncident.dao.Vehicule;
import jpa.ficheIncident.dao.VehiculeDao;
import jpa.ficheIncident.dao.VehiculeDaoFactory;



public class TestJpaVehiculeDao {
	public static void main(String[] args) {
		//TestJpaVehiculeDao.testerCrudVehicule(VehiculeDaoFactory.JPA_DAO);
		TestJpaVehiculeDao.testerlisteVehiculeDepannage(VehiculeDaoFactory.JPA_DAO);
	}

	
	
	private static void testerlisteVehiculeDepannage(String jpaDao) {
		VehiculeDao vehiculeDao = VehiculeDaoFactory.getVehiculeDao(jpaDao);
		List<Vehicule> listeTousLesVehicules =vehiculeDao.listeVehiculeDepannage();
		// Afficher les vÃ©hicules recherchÃ©s
		for (Vehicule vehicule : listeTousLesVehicules) {
			System.out.println("#- id:" + vehicule.getId().longValue() + ",codeInterne:" + vehicule.getCodeInterne() + ", immat:"
		+ vehicule.getImmatriculation() + ",dateMEC:" + (vehicule.getDateMiseEnCirculation()));
		}
		

	}
	private static void testerCrudVehicule(String typeDao) {
		try {
			VehiculeDao vehiculeDao = VehiculeDaoFactory.getVehiculeDao(typeDao);
			vehiculeDao.insererVehicule("veh1", "12-H-38779", "2018-10-24",false);
			vehiculeDao.insererVehicule("veh2", "10-A-66759", "2019-06-25",false);
			vehiculeDao.insererVehicule("DEP H", "1-H-91226", "2018-12-26",true);
			Vehicule veh1 = new Vehicule();
			veh1.setCodeInterne("veh4");
			veh1.setImmatriculation("AA-BB-CC");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMdd");
			Date utildate = simpleDateFormat.parse("2010-11-11");
			veh1.setDateMiseEnCirculation(utildate);
			vehiculeDao.insererVehicule(veh1);
			Vehicule veh2 = new Vehicule();
			veh2.setCodeInterne("veh5");
			veh2.setImmatriculation("JJ-BB-CC");
			Date utildate1 = simpleDateFormat.parse("2012-12-12");
			veh2.setDateMiseEnCirculation(utildate1);
			vehiculeDao.insererVehicule(veh2);
// Rechercher tous les véhicules
			List<Vehicule> listeTousLesVehicules = vehiculeDao.rechercherTousLesVehicules();
// Afficher les véhicules recherchés
			for (Vehicule vehicule : listeTousLesVehicules) {
				System.out.println("#- id:" + vehicule.getId().longValue() + ", codeInterne:"
						+ vehicule.getCodeInterne() + ", immat:" + vehicule.getImmatriculation() + ", dateMEC:"
						+ (vehicule.getDateMiseEnCirculation()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

