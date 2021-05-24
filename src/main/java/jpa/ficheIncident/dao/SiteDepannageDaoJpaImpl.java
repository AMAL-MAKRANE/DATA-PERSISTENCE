package jpa.ficheIncident.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;



public class SiteDepannageDaoJpaImpl implements SiteDepannageDao {

	private EntityManager em;

	public SiteDepannageDaoJpaImpl(EntityManager em) {
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
	

	public void insererSite(SiteDepannage _Site) {
		// TODO Auto-generated method stub
		EntityTransaction etx = null ;
		try {
			etx = this. em.getTransaction();
			etx.begin();
			this. em.persist( _Site);
			etx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (etx != null ) {
				etx.rollback();
			}
		}

	}


	public List<SiteDepannage> rechercherTousLesSites() {
		// TODO Auto-generated method stub
		String queryString = "select * from Site";
		Query query = this.em.createNativeQuery(queryString, SiteDepannage.class);
		return query.getResultList();
	}


	public SiteDepannage rechercherSite(Long _id) {
		// TODO Auto-generated method stub
		return this.em.find(SiteDepannage.class, _id);

	}




	public void modifierSite(SiteDepannage _Site) {
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			this.em.merge(_Site);
			etx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (etx != null) {
				etx.rollback();
			}
		}

	}



	public void supprimerSite(SiteDepannage _Site) {
		// TODO Auto-generated method stub
		EntityTransaction etx = null;
		try {
			// Initialiser une transaction JPA
			etx = this.em.getTransaction();
			etx.begin();

			this.em.remove(_Site);
			// Commiter la transaction JPA
			etx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (etx != null) {
				etx.rollback();
			}
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<Object[]> listerSite(){
		String jpqlquery = "SELECT s.id,s.code,s.description,s.libelle FROM SiteDepannage s";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List<Vehicule> listeVehiculeDepannage() {
		String jpqlquery= "SELECT v FROM vehicule v WHERE v.code_interne='DEP%";
		Query query= this.em.createQuery(jpqlquery);
	    return query.getResultList();
		
	}

	


}
