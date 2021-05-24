package jpa.ficheIncident;

import java.util.ArrayList;
import java.util.List;


import jpa.ficheIncident.dao.Chauffeur;
import jpa.ficheIncident.dao.ChauffeurDao;
import jpa.ficheIncident.dao.ChauffeurDaoFactory;

public class TestJpaChauffeurDao {
	public static void main(String[] args) {
		TestJpaChauffeurDao.testerCrudChauffeur(ChauffeurDaoFactory.JPA_DAO);
	}
	private static void testerCrudChauffeur(String typeDao) {
		try {
			ChauffeurDao chauffeurDao = ChauffeurDaoFactory.getChauffeurDao(typeDao);
			// Test Insertion
			
			Chauffeur chauf1 = new Chauffeur();
			chauf1.setMatricule("CH-123");
			chauf1.setNom("Karim");
			chauf1.setPrenom("Ahmed");
			chauf1.setTelephone("12346798");
			chauffeurDao.insererChauffeur(chauf1);
			Chauffeur chauf2 = new Chauffeur();
			chauf2.setMatricule("CH-567");
			chauf2.setNom("Khalid");
			chauf2.setPrenom("Mohammed");
			chauf2.setTelephone("9876543221");
			chauffeurDao.insererChauffeur(chauf2); 
			
			// Test Lister
			List<Chauffeur> listeChauffeurs = new ArrayList<Chauffeur>();
			listeChauffeurs = chauffeurDao.rechercherTousLesChauffeurs();
			for (Chauffeur chau : listeChauffeurs) {
				System.out.println("#- id:" + chau.getId().longValue() + ",matricule:" + chau.getMatricule() + ", Nom:"
				+ chau.getNom() + ", Prénom:" +
				chau.getPrenom());
			}
			// Tester recherche par Id
			
			System.out.println("le nom du chauffeur dont l'id est égal à 2 est:" + chauffeurDao.rechercherChauffeurParId(2L).getNom());
			
			// Tester Modification
			Chauffeur chauf3 = new Chauffeur();
			chauf3 = chauffeurDao.rechercherChauffeurParId(1L);
			chauf3.setNom("Karimi");
			chauffeurDao.modifierChauffeur(chauf3);
			System.out.println("le nouveau matricule du chauffeur dont l'id est égal à 1 est :" + chauf2.getMatricule());
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	}