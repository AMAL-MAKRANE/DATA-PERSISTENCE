package jpa.ficheIncident.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AgentDeclarantDaoJpaImpl implements AgentDeclarantDao {
	
	private EntityManager em;
	
	public AgentDeclarantDaoJpaImpl(EntityManager em) {
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
	
	
	
	
	
	public void insererAgentDeclarant(AgentDeclarant _agentDeclarant) {
	// TODO Auto-generated method stub
		EntityTransaction etx = null ;
		try {
			etx = this. em.getTransaction();
			etx.begin();
			this. em.persist( _agentDeclarant);
			etx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (etx != null ) {
					etx.rollback();
				}
			}

	}
	
	
	public List<AgentDeclarant> rechercherTousLesAgentDeclarants() {
	// TODO Auto-generated method stub
		String queryString = "select * from Chauffeur;";
		Query query = this.em.createNativeQuery(queryString, AgentDeclarant.class);
		return query.getResultList();
	}
	
	
	public AgentDeclarant rechercherAgentDeclarantParId(Long _id) {
	// TODO Auto-generated method stub
		return this.em.find(AgentDeclarant.class, _id);
	
	}
	
	
	
	
	public void modifierAgentDeclarant(AgentDeclarant _agentDeclarant) {
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			this.em.merge(_agentDeclarant);
			etx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (etx != null) {
				etx.rollback();
			}
		}
	
	}
	
	
	
	public void  supprimerAgentDeclarantParId(AgentDeclarant _agentDeclarant) {
		// TODO Auto-generated method stub
				EntityTransaction etx = null;
				try {
				// Initialiser une transaction JPA
				etx = this.em.getTransaction();
				etx.begin();
				
				this.em.remove(_agentDeclarant);
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
