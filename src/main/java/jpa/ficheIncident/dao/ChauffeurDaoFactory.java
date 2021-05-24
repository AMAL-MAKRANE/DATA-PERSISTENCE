package jpa.ficheIncident.dao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class ChauffeurDaoFactory {
	public static final String JPA_DAO = "jpa_dao";
	
	public static ChauffeurDao getChauffeurDao(String typeDao) {
		if (ChauffeurDaoFactory.JPA_DAO.equals(typeDao)) {
			return ChauffeurDaoFactory.getChauffeurDaoJpa();
		} else {
			return null;
		}
	}
	private static ChauffeurDao getChauffeurDaoJpa() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE");
			return new ChauffeurDaoJpaImpl(emf.createEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}