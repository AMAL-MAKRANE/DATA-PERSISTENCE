package jpa.ficheIncident.dao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class FicheIncidentDaoFactory {
	public static final String JPA_DAO = "jpa_dao";
	
	public static FicheIncidentDao getFicheIncidentDao(String typeDao) {
		if (FicheIncidentDaoFactory.JPA_DAO.equals(typeDao)) {
			return FicheIncidentDaoFactory.getFicheIncidentDaoJpa();
		} else {
			return null;
		}
	}
	private static FicheIncidentDao getFicheIncidentDaoJpa() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE");
			return new FicheIncidentDaoJpaImpl(emf.createEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}