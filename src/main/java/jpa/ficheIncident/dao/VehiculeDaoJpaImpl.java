package jpa.ficheIncident.dao;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class VehiculeDaoJpaImpl implements VehiculeDao {
	
	private EntityManager em;
	
	public VehiculeDaoJpaImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	protected void finalize() throws Throwable {
		if ((this.em != null) && this.em.isOpen()) {
			try {
				this.em.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.finalize();
	}
	
	@Override
	public void insererVehicule(String _codeInterne, String _immatriculation, String _dateMiseEnCirculation,boolean _depannage) {
		// TODO Auto-generated method stub
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			Vehicule vehicule = new Vehicule();
			vehicule.setCodeInterne(_codeInterne);
			vehicule.setImmatriculation(_immatriculation);
			vehicule.setDepannage(_depannage);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utildate = simpleDateFormat.parse(_dateMiseEnCirculation);
			vehicule.setDateMiseEnCirculation(utildate);
			this.em.persist(vehicule);
			etx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if (etx != null) {
				etx.rollback();
			}
		}

	}
	
	@Override
	public void insererVehicule(Vehicule _vehicule) {
	// TODO Auto-generated method stub
		EntityTransaction etx = null ;
		try {
			etx = this. em.getTransaction();
			etx.begin();
			this. em.persist(_vehicule);
			etx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (etx != null ) {
					etx.rollback();
				}
			}

	}
	
	@Override
	public List<Vehicule> rechercherTousLesVehicules() {
	// TODO Auto-generated method stub
		String queryString = "select * from Vehicule;";
		Query query = this.em.createNativeQuery(queryString, Vehicule.class);
		return query.getResultList();
	}
	
	@Override
	public Vehicule rechercherVehiculeParId(Long _id) {
	// TODO Auto-generated method stub
		return this.em.find(Vehicule.class, _id);
	
	}
	
	@Override
	public List<Vehicule> rechercherVehiculeParImmatriculation(String _immatriculation)
	{
	// TODO Auto-generated method stub
		String queryString = "select * from vehicule where immatriculation = ?";
		Query query = this.em.createNativeQuery(queryString, Vehicule.class);
		query.setParameter(1, _immatriculation);
		return query.getResultList();

	}
	
	@Override
	public void modifierVehiculeCodeInterneParId(Long _id, String _codeInterne) {
		// TODO Auto-generated method stub
		Vehicule vehicule = this.em.find(Vehicule.class, _id);
			if (vehicule != null) {
				EntityTransaction etx = null;
				try {
					etx = this.em.getTransaction();
					etx.begin();
					vehicule.setCodeInterne(_codeInterne);
					etx.commit();
				} catch (Exception e) {
					e.printStackTrace();
					if (etx != null) {
					etx.rollback();
				}
				}
		}
		
	}
	
	@Override
	public void modifierVehiculeCodeInterneParId(Vehicule _vehicule) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			this.em.merge(_vehicule);
			etx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (etx != null) {
				etx.rollback();
			}
		}
		
	}
	
	
	public void supprimerVehiculeParId(Long _id) {
	// TODO Auto-generated method stub
	}
	
	@Override
	public void supprimerVehiculeParId(Vehicule _vehicule) {
		// TODO Auto-generated method stub
		EntityTransaction etx = null;
		try {
		// Initialiser une transaction JPA
		etx = this.em.getTransaction();
		etx.begin();
		
		this.em.remove(_vehicule);
		// Commiter la transaction JPA
		etx.commit();
		} catch (Exception e) {
		e.printStackTrace();
		if (etx != null) {
		etx.rollback();
		}
		}	
}
	@Override
	public List<Vehicule> listeVehiculesLesPlusNeufs() {
		String jpqlquery = "select v from Vehicule v where v.dateMiseEnCirculation in (select max(v1.dateMiseEnCirculation) from Vehicule v1)";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Vehicule> listeVehiculeDepannage() {
		String jpqlquery= "SELECT v FROM Vehicule v WHERE v.depannage=true";
		Query query= this.em.createQuery(jpqlquery);
	    return query.getResultList();
		
	}
}
