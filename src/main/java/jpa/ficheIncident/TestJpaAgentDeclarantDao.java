package jpa.ficheIncident;

import java.util.ArrayList;
import java.util.List;

import jpa.ficheIncident.dao.AgentDeclarant;
import jpa.ficheIncident.dao.AgentDeclarantDao;
import jpa.ficheIncident.dao.AgentDeclarantDaoFactory;
import jpa.ficheIncident.dao.FicheIncident;

public class TestJpaAgentDeclarantDao {
	public static void main(String[] args) {
		//TestJpaAgentDeclarantDao.testerCrudAgentDeclarant(AgentDeclarantDaoFactory.JPA_DAO);
		TestJpaAgentDeclarantDao.testerManyToOneAfficherFichesAgent(AgentDeclarantDaoFactory.JPA_DAO);
			}
	private static void testerCrudAgentDeclarant(String typeDao) {
		try {
			AgentDeclarantDao agentDeclarantDao = AgentDeclarantDaoFactory.getAgentDeclarantDao(typeDao);
			
			AgentDeclarant agDec = new AgentDeclarant();
			agDec.setMatricule("AG123");
			agDec.setNom("Youssef");
			agDec.setPrenom("Abdellah");
			
			agentDeclarantDao.insererAgentDeclarant(agDec);
			
			AgentDeclarant agDec1 = new AgentDeclarant();
			agDec1.setMatricule("AG567");
			agDec1.setNom("Wassel");
			agDec1.setPrenom("Naoufal");
			
			agentDeclarantDao.insererAgentDeclarant(agDec1);
			
			List<AgentDeclarant> listeAgDeclarants = new ArrayList<AgentDeclarant>();
			
			listeAgDeclarants = agentDeclarantDao.rechercherTousLesAgentDeclarants();
			
			for (AgentDeclarant chau : listeAgDeclarants) {
				System.out.println("#- id:" + chau.getId().longValue()
				+ ", matricule:" + chau.getMatricule() + ", Nom:"
				+ chau.getNom() + ", Prénom:" + chau.getPrenom());
			}
			
			long id = 1;
			AgentDeclarant agDec2 = new AgentDeclarant();
			agDec2 = agentDeclarantDao.rechercherAgentDeclarantParId(id);
			agDec2.setNom("Youssoufi");
			agentDeclarantDao.modifierAgentDeclarant(agDec2);
			System.out.println("le nouveau nom de l'agent declarant dont l'id est égal à 1 est :" + agDec.getNom());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testerManyToOneAfficherFichesAgent(String typeDao) {
		try {
			AgentDeclarantDao agentDeclarantDao =
			AgentDeclarantDaoFactory.getAgentDeclarantDao(typeDao);
			AgentDeclarant agDec3 = new AgentDeclarant();
			agDec3 = agentDeclarantDao.rechercherAgentDeclarantParId(1L);
			List<FicheIncident> listeFiche = new ArrayList<>();
			listeFiche = agDec3.getFichesIncidentsDeclarees();
			for (FicheIncident fiche : listeFiche) {
			System.out.println("#- id:" + fiche.getId().longValue() + ",Date de l'incident:"
			+ fiche.getDate_incident() + ", Nombre Voyageurs:" + fiche.getNombre_voyageur() + ", Description:"
			+ fiche.getDescription_incident() + ", Lieu de l'incident:" + fiche.getLieu_incident());
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			}
}
