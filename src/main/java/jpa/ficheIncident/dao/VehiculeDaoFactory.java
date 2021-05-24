package jpa.ficheIncident.dao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class VehiculeDaoFactory {
	public static final String JPA_DAO = "jpa_dao";
	
	public static VehiculeDao getVehiculeDao(String typeDao) {
		if (VehiculeDaoFactory.JPA_DAO.equals(typeDao)) {
			return VehiculeDaoFactory.getVehiculeDaoJpa();
		} else {
			return null;
		}
	}
	private static VehiculeDao getVehiculeDaoJpa() {
		try {
			EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE");
			return new VehiculeDaoJpaImpl(emf.createEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}