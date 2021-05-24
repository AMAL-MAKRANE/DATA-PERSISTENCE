package jpa.ficheIncident;

import jpa.ficheIncident.dao.AgentDeclarant;
import jpa.ficheIncident.dao.AgentDeclarantDao;
import jpa.ficheIncident.dao.AgentDeclarantDaoFactory;
import jpa.ficheIncident.dao.FicheIncident;
import jpa.ficheIncident.dao.FicheIncidentDao;
import jpa.ficheIncident.dao.FicheIncidentDaoFactory;
import jpa.ficheIncident.dao.Vehicule;
import jpa.ficheIncident.dao.VehiculeDao;
import jpa.ficheIncident.dao.VehiculeDaoFactory;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJpaFicheDao {
	public static void main(String[] args) {
		//TestJpaFicheDao.testerCrudFiche(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerManyToOneFicheAgDec(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerManyToOneAfficherAgDec(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.afficherToutesLesFiches(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerManyToOneFicheVehicule(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerManyToOneAfficherVehicule(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerCascadeAgentDeclarant(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerFichesMarrakech(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerIncidentsCritiques(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerNbIncidentParLieu(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerNombreIncidentsParAgent(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerVehiculeCritique(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerNbIncidentCrParV(FicheIncidentDaoFactory.JPA_DAO);
		//TestJpaFicheDao.testerlisteLesPlusRecentIncidentAccident(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerFrequenceIncident(FicheIncidentDaoFactory.JPA_DAO);
//		TestJpaFicheDao.testerClassementChauffeurs(FicheIncidentDaoFactory.JPA_DAO);
		//TestJpaFicheDao.testerChauffeurAucunIncident(FicheIncidentDaoFactory.JPA_DAO);
		TestJpaFicheDao.testerTempsAttenteMaximum(FicheIncidentDaoFactory.JPA_DAO);
	
	}
	
	
	
	private static void testerTempsAttenteMaximum(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> listefiche = ficheDao.tempsAttenteMaximum();
	
		System.out.println("L'incident qui a nécessité le temps d'attente le plus important : " );
		for (Object[] e : listefiche) {
			System.out.println( " #- id :" +((Long) e[0]).longValue()
					+" , numéro fichier : " + e[1] 
					+" , date de déclaration : " + e[2]
					+" , date de reprise : " + e[3]);
		}
}	
	
	
	
	
	private static void testerChauffeurAucunIncident(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> listeChauffeurs = ficheDao.chauffeurAucunIncident();
	
		System.out.println("Les chauffeurs n'ayant était impliqué en aucun incident : " );
		for (Object[] e : listeChauffeurs) {
			System.out.println( " #- id chauffeur :" +((Long) e[0]).longValue()
					+" , nom complet : " + e[1] + " "+e[2]
					+" , matricule : " + e[3]  );
		}
}
	
	
	
	
	
	
	
	private static void testerClassementChauffeurs(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> listeClassementChauffeurs = ficheDao.classementChauffeurs();
	
		System.out.println("Le classement des chauffeurs par le nombre d'incidents : " );
		for (Object[] e : listeClassementChauffeurs) {
			System.out.println( " #- id chauffeur :" +((Long) e[0]).longValue()
					+" , nom complet : " + e[1] + " "+e[2]
					+" , nombre d'incidents : " + e[3]  );
		}
	}
	private static void testerFrequenceIncident(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> listeFrequence = ficheDao.frequenceIncident();
		// Afficher les fiches recherchés
		System.out.println("La fréquence de chaque type d'incident : " );
		for (Object[] e : listeFrequence) {
			System.out.println( " #- Type :" + e[0]
					+" , fréquence : " + e[1]  );
		}
}
	
	
	
	
	
	
	
	private static void testerlisteLesPlusRecentIncidentAccident(String typeDao) {

		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<FicheIncident> listf = ficheDao.listeLesPlusRecentIncidentAccident();
		for (FicheIncident i : listf) {
			System.out.println("#id- :" + i.getId() + " || " + "Lieu incident :" + i.getLieu_incident() + " || "
					+ "fiche incident :" + i.getNumero_fiche());
		}

	}

	private static void testerCrudFiche(String typeDao) {
		try {
			FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			FicheIncident fiche7 = new FicheIncident();
			fiche7.setLieu_incident("meknes");
			fiche7.setDescription_incident("mortel");
			fiche7.setChauffeur_id(1);
			fiche7.setIncident_critique(true);
			fiche7.setNombre_voyageur(123);
			fiche7.setNumero_fiche("F2019-01-01-N1");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM-dd HH:mm");
			Date dateIncident = simpleDateFormat.parse("2019-01-01 06:05");
			fiche7.setDate_incident(dateIncident);
			Date dateDeclaration = simpleDateFormat.parse("2019-01-01 07:05");
			fiche7.setDate_declaration(dateDeclaration);
			Date dateReprise = simpleDateFormat.parse("2019-01-01 12:30");
			fiche7.setDate_reprise(dateReprise);
			
			ficheDao.insererFicheIncidentVoyage(fiche7);
			
			FicheIncident fiche8 = new FicheIncident();
			fiche8.setLieu_incident("Marrakech");
			fiche8.setDescription_incident("mortel");
			fiche8.setChauffeur_id(1);
			fiche8.setIncident_critique(true);
			fiche8.setNombre_voyageur(163);
			fiche8.setNumero_fiche("F2019-01-01-N55");
			
			 dateIncident = simpleDateFormat.parse("2019-11-01 06:05");
			fiche8.setDate_incident(dateIncident);
			 dateDeclaration = simpleDateFormat.parse("2019-11-01 07:05");
			fiche8.setDate_declaration(dateDeclaration);
			 dateReprise = simpleDateFormat.parse("2019-11-01 12:30");
			fiche8.setDate_reprise(dateReprise);
			
			ficheDao.insererFicheIncidentVoyage(fiche8);
			
			FicheIncident fiche9 = new FicheIncident();
			fiche9.setLieu_incident("casa");
			fiche9.setDescription_incident("le");
			fiche9.setChauffeur_id(1);
			fiche9.setIncident_critique(true);
			fiche9.setNombre_voyageur(123);
			fiche9.setNumero_fiche("F2019-01-01-N166");
			
			 dateIncident = simpleDateFormat.parse("2019-12-01 06:05");
			fiche9.setDate_incident(dateIncident);
			 dateDeclaration = simpleDateFormat.parse("2019-12-01 07:05");
			fiche9.setDate_declaration(dateDeclaration);
			dateReprise = simpleDateFormat.parse("2019-12-01 12:30");
			fiche9.setDate_reprise(dateReprise);
			
			ficheDao.insererFicheIncidentVoyage(fiche9);
//
//			FicheIncident fiche1 = new FicheIncident();
//			fiche1.setLieu_incident("Marrakech");
//			fiche1.setDescription_incident("mortel");
//			fiche1.setType_incident("conflit");
//			fiche1.setIncident_critique(true);
//			fiche1.setNombre_voyageur(123);
//			fiche1.setNumero_fiche("F2019-01-01-N1");
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM-dd HH:mm");
//			Date dateIncident = simpleDateFormat.parse("2019-01-01 06:05");
//			fiche1.setDate_incident(dateIncident);
//			Date dateDeclaration = simpleDateFormat.parse("2019-01-01 07:05");
//			fiche1.setDate_declaration(dateDeclaration);
//			Date dateReprise = simpleDateFormat.parse("2019-01-01 12:30");
//			fiche1.setDate_reprise(dateReprise);
//			
//			ficheDao.insererFicheIncidentVoyage(fiche1);
//			
//			FicheIncident fiche2 = new FicheIncident();
//			fiche2.setLieu_incident("Agadir");
//			fiche2.setIncident_critique(false);
//			fiche2.setDescription_incident("léger");
//			fiche1.setType_incident("Panne");			
//			fiche2.setNombre_voyageur(12);
//			fiche2.setNumero_fiche("F2019-08-01-N10");
//			dateIncident = simpleDateFormat.parse("2019-08-01 08:05");
//			fiche2.setDate_incident(dateIncident);
//			dateDeclaration = simpleDateFormat.parse("2019-08-01 09:10");
//			fiche2.setDate_declaration(dateDeclaration);
//			dateReprise = simpleDateFormat.parse("2019-08-01 12:30");
//			fiche2.setDate_reprise(dateReprise);
//			
//			ficheDao.insererFicheIncidentVoyage(fiche2);
//			
			// rechercher toutes les fiches
			List<FicheIncident> listeFiches = new ArrayList<>();
			listeFiches = ficheDao.rechercherTousLesFicheIncidentVoyages();
			for (FicheIncident fiche : listeFiches) {
				System.out.println("#- id:" + fiche.getId().longValue()
				+ ", Numéro:" + fiche.getNumero_fiche()
				+ ", date:" + fiche.getDate_incident() +
				", Lieu:" + fiche.getLieu_incident()
				+ ", Date Déclaration:" +
				fiche.getDate_declaration() + ", Type d'incident:" +
						fiche.getType_incident() + ", date de Reprise:"
				+ fiche.getDate_reprise() + ", Nombre de Voyageurs:" 
				+ fiche.getNombre_voyageur());
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	private static void testerManyToOneFicheAgDec(String typeDao) {
		try {
			
			FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			AgentDeclarantDao agentDeclarantDao = AgentDeclarantDaoFactory.getAgentDeclarantDao(typeDao);
			
			// Création d'une fiche à laquelle on associe l'agent n°1
			AgentDeclarant agDec = agentDeclarantDao.rechercherAgentDeclarantParId(1L);
			FicheIncident fiche1 = new FicheIncident();
			fiche1.setLieu_incident("Ifrane");
			fiche1.setDescription_incident("Panne moteur");
			fiche1.setType_incident("Panne");	
			fiche1.setIncident_critique(true);
			fiche1.setNombre_voyageur(70);
			fiche1.setNumero_fiche("F2019-09-10-N1");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date dateIncident = simpleDateFormat.parse("2019-09-10 06:05");
			fiche1.setDate_incident(dateIncident);
			Date dateDeclaration = simpleDateFormat.parse("2019-09-10 07:05");
			fiche1.setDate_declaration(dateDeclaration);
			Date dateReprise = simpleDateFormat.parse("2019-09-10 12:30");
			fiche1.setDate_reprise(dateReprise);
			
			fiche1.setAgentDeclarant(agDec);
			ficheDao.insererFicheIncidentVoyage(fiche1);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	private static void testerManyToOneAfficherAgDec(String typeDao) {
		try {
			FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			
			FicheIncident f = new FicheIncident();
			f = ficheDao.rechercherFicheIncidentVoyageParId(3L);
			AgentDeclarant idAgDec = f.getAgentDeclarant();
			System.out.println("Le nom de l'agent ayant saisi la fiche dont l'id est 3 est : "
					+  idAgDec.getNom() +" "+ idAgDec.getPrenom());
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	private static void afficherToutesLesFiches(String typeDao) {
		try {
			FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			
			List<FicheIncident> listeFiches = new ArrayList<>();
			listeFiches = ficheDao.rechercherTousLesFicheIncidentVoyages();
			
			for (FicheIncident fiche : listeFiches) {
				
				if(fiche.getAgentDeclarant() != null && fiche.getAgentDeclarant().getId()==1L) {
					System.out.println("#- id:" + fiche.getId().longValue()
					+ ", Numéro:" + fiche.getNumero_fiche()
					+ ", date:" + fiche.getDate_incident() +
					", Lieu:" + fiche.getLieu_incident()
					+ ", Date Déclaration:" +
					fiche.getDate_declaration() + ", date de Reprise:"
					+ fiche.getDate_reprise() + ", Nombre de Voyageurs:" 
					+ fiche.getNombre_voyageur());
				}
			}
	} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	private static void testerManyToOneFicheVehicule(String typeDao) {
		try {
			FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			
			AgentDeclarantDao agentDeclarantDao = AgentDeclarantDaoFactory.getAgentDeclarantDao(typeDao);
			VehiculeDao vehiculeDao = VehiculeDaoFactory.getVehiculeDao(typeDao);
			Vehicule veh1 = vehiculeDao.rechercherVehiculeParId(5L);
			AgentDeclarant agDec = agentDeclarantDao.rechercherAgentDeclarantParId(1L);
			FicheIncident fiche1 = new FicheIncident();
			fiche1.setLieu_incident("GrandCasaBlanca");
			fiche1.setDescription_incident("Critique");
			fiche1.setIncident_critique(true);
			fiche1.setNombre_voyageur(123);
			fiche1.setNumero_fiche("F2019-09-10-N190");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date dateIncident = simpleDateFormat.parse("2019-09-10 06:05");
			fiche1.setDate_incident(dateIncident);
			Date dateDeclaration = simpleDateFormat.parse("2019-09-10 07:05");
			fiche1.setDate_declaration(dateDeclaration);
			Date dateReprise = simpleDateFormat.parse("2019-09-10 12:30");
			fiche1.setDate_reprise(dateReprise);
			fiche1.setAgentDeclarant(agDec);
			fiche1.setVehicule(veh1);
			ficheDao.insererFicheIncidentVoyage(fiche1);
		} catch (Exception e) {
			e.printStackTrace();
					}
					}
	private static void testerManyToOneAfficherVehicule(String typeDao) {
		try {
			FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
			
			FicheIncident f = new FicheIncident();
			f = ficheDao.rechercherFicheIncidentVoyageParId(4L);
			Vehicule v = f.getVehicule();
			System.out.println("le matricule du véhicule sujet de la fiche dont l’id est 4 : "
					+  v.getImmatriculation() );
		} catch (Exception e) {
			e.printStackTrace();
			}
		
	}
	
	private static void testerCascadeAgentDeclarant(String typeDao) {
		try {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		VehiculeDao vehiculeDao = VehiculeDaoFactory.getVehiculeDao(typeDao);
		Vehicule vehicule = vehiculeDao.rechercherVehiculeParId(1L);
		// Test Cascade
		AgentDeclarant agDec = new AgentDeclarant();
		agDec.setMatricule("AG787");
		agDec.setNom("Anouar");
		agDec.setPrenom("Youness");
		FicheIncident fiche4 = new FicheIncident();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date dateIncident = simpleDateFormat.parse("2019-10-10 06:05");
		fiche4.setDate_incident(dateIncident);
		Date dateDeclaration = simpleDateFormat.parse("2019-10-10 07:05");
		fiche4.setDate_declaration(dateDeclaration);
		Date dateReprise = simpleDateFormat.parse("2019-10-10 12:30");
		fiche4.setDate_reprise(dateReprise);
		fiche4.setLieu_incident("Taounate");
		fiche4.setIncident_critique(false);
		fiche4.setDescription_incident("léger");
		fiche4.setNombre_voyageur(56);
		fiche4.setNumero_fiche("F2019-10-10-N590");
		fiche4.setAgentDeclarant(agDec);
		fiche4.setVehicule(vehicule);
		ficheDao.insererFicheIncidentVoyage(fiche4);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	private static void testerFichesMarrakech(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<FicheIncident> listeFichesMarrakech = ficheDao.listeFichesMarrakech();
		//afficher les fiches concernées
		for (FicheIncident f : listeFichesMarrakech) {
			System.out.println(
			"#- id:" + f.getId().longValue() + ", numero fiche:" + f.getNumero_fiche());
		}
		}
	private static void testerIncidentsCritiques(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<FicheIncident> listeIncidentsCritiques = ficheDao.listeIncidentsCritiques();
		//afficher les fiches concernées
		for (FicheIncident f : listeIncidentsCritiques) {
			System.out.println(
			"#- id:" + f.getId().longValue() + ", numero fiche:" + f.getNumero_fiche()
			+", Description:" + f.getDescription_incident());
		}
		}
	
	private static void testerNbIncidentParLieu(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> nbIncidentParLieu = ficheDao.NombreIncidentsParLieu();
		//afficher les fiches concernées
		for (Object[] f : nbIncidentParLieu) {
			
			System.out.println(Arrays.toString(f));
			
		}
		}
	
	private static void testerNombreIncidentsParAgent(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> nbIncidentParAgent = ficheDao.NombreIncidentsParAgent();
		//afficher les fiches concernées
		for (Object[] f : nbIncidentParAgent) {
			
			System.out.println(Arrays.toString(f));
			
		}
		}
	
	private static void testerVehiculeCritique(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> listeVehiculeCritique = ficheDao.vehiculeCritique();
		// Afficher les véhicules recherchés
		for (Object[] vehicule : listeVehiculeCritique) {
			System.out.println("les véhicules ayant subi des incidents critiques : \n" 
					+Arrays.toString(vehicule));
		}
		
		}
	
	private static void testerNbIncidentCrParV(String typeDao) {
		
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> listeVehicules = ficheDao.nombreIncidentCritiqueParVehicule();
		VehiculeDao vehiculeDao = VehiculeDaoFactory.getVehiculeDao(typeDao);
		List<Vehicule> listeTousLesVehicules = vehiculeDao.rechercherTousLesVehicules();
		
		// Afficher les véhicules recherchés
		System.out.println("les véhicules avec le nombre d'incidents critiques subis : ");
		for (Object[] e : listeVehicules) {
			System.out.println( "#-id :" + ((Long) e[0]).longValue()
					+" , code interne : " + e[1] +" , immatriculation : " + e[2]
							+" , DMC : " +  e[3]
					+" , Nb d'incidents critiques : " +  e[4]);
			
			}
	
	}

	private static void testerIncidentTrieParDureeDesc(String typeDao) {
		FicheIncidentDao ficheDao = FicheIncidentDaoFactory.getFicheIncidentDao(typeDao);
		List<Object[]> listeFichesTrie = ficheDao.incidentTrieParDureeDesc();
		// Afficher les fiches recherchés
		System.out.println("la liste des fiches triées par la durée : " );
		for (Object[] e : listeFichesTrie) {
			System.out.println( " #-id :" + ((Long) e[0]).longValue()
					+" , numéro fiche : " + e[1] +" , durée : " + e[2]+"h "+ e[3]+ "min");
		}
	}
}