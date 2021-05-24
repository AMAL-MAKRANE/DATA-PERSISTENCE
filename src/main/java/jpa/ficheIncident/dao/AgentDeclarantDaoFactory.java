package jpa.ficheIncident.dao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class AgentDeclarantDaoFactory {
	public static final String JPA_DAO = "jpa_dao";
	
	public static AgentDeclarantDao getAgentDeclarantDao(String typeDao) {
		if (AgentDeclarantDaoFactory.JPA_DAO.equals(typeDao)) {
			return AgentDeclarantDaoFactory.getAgentDeclarantDaoJpa();
		} else {
			return null;
		}
	}
	private static AgentDeclarantDao getAgentDeclarantDaoJpa() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE");
			return new AgentDeclarantDaoJpaImpl(emf.createEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}