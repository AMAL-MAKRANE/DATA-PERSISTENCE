package jpa.ficheIncident.dao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SiteDepannageDaoFactory {
	public static final String JPA_DAO = "jpa_dao";
	
	public static SiteDepannageDao getSiteDao(String typeDao) {
		if (SiteDepannageDaoFactory.JPA_DAO.equals(typeDao)) {
			return SiteDepannageDaoFactory.getSiteDaoJpa();
		} else {
			return null;
		}
	}
	
	private static SiteDepannageDao getSiteDaoJpa() {
		try {
			EntityManagerFactory emf =Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE");
			return new SiteDepannageDaoJpaImpl(emf.createEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		return null;
		}
	}
}
