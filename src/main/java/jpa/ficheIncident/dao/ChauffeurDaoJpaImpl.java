package jpa.ficheIncident.dao;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ChauffeurDaoJpaImpl implements ChauffeurDao {
	
	private EntityManager em;
	
	public ChauffeurDaoJpaImpl(EntityManager em) {
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
	
	
	
	
	
	public void insererChauffeur(Chauffeur _Chauffeur) {
	// TODO Auto-generated method stub
		EntityTransaction etx = null ;
		try {
			etx = this. em.getTransaction();
			etx.begin();
			this. em.persist( _Chauffeur);
			etx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (etx != null ) {
					etx.rollback();
				}
			}

	}
	
	
	public List<Chauffeur> rechercherTousLesChauffeurs() {
	// TODO Auto-generated method stub
		String queryString = "select * from Chauffeur;";
		Query query = this.em.createNativeQuery(queryString, Chauffeur.class);
		return query.getResultList();
	}
	
	
	public Chauffeur rechercherChauffeurParId(Long _id) {
	// TODO Auto-generated method stub
		return this.em.find(Chauffeur.class, _id);
	
	}
	
	
	
	
	public void modifierChauffeur(Chauffeur _Chauffeur) {
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			this.em.merge(_Chauffeur);
			etx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (etx != null) {
				etx.rollback();
			}
		}
	
	}
	
	
	
	public void supprimerChauffeur(Chauffeur _Chauffeur) {
		// TODO Auto-generated method stub
				EntityTransaction etx = null;
				try {
				// Initialiser une transaction JPA
				etx = this.em.getTransaction();
				etx.begin();
				
				this.em.remove(_Chauffeur);
				// Commiter la transaction JPA
				etx.commit();
				} catch (Exception e) {
				e.printStackTrace();
				if (etx != null) {
				etx.rollback();
				}
				}
	}
}
