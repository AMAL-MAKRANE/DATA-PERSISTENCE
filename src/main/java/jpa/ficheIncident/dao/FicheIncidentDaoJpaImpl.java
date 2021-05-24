package jpa.ficheIncident.dao;
//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public  class FicheIncidentDaoJpaImpl implements FicheIncidentDao {
	
	private EntityManager em;
	
	public FicheIncidentDaoJpaImpl(EntityManager em) {
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
	
	public void insererFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage) {
		// TODO Auto-generated method stub
			EntityTransaction etx = null ;
			try {
				etx = this. em.getTransaction();
				etx.begin();
				this. em.persist( _ficheIncidentVoyage);
				etx.commit();
				} catch (Exception e) {
					e.printStackTrace();
					if (etx != null ) {
						etx.rollback();
					}
				}

		}
	
	public List<FicheIncident> rechercherTousLesFicheIncidentVoyages() {
		// TODO Auto-generated method stub
			String queryString = "select * from FicheIncident;";
			Query query = this.em.createNativeQuery(queryString, FicheIncident.class);
			return query.getResultList();
		}
	
	public FicheIncident rechercherFicheIncidentVoyageParId(Long _id) {
		// TODO Auto-generated method stub
			return this.em.find(FicheIncident.class, _id);
		
		}
	
	public void modifierFicheIncidentVoyage(FicheIncident _ficheIncidentVoyage) {
		EntityTransaction etx = null;
		try {
			etx = this.em.getTransaction();
			etx.begin();
			this.em.merge(_ficheIncidentVoyage);
			etx.commit();
		} catch (Exception e) {
				e.printStackTrace();
				if (etx != null) {
					etx.rollback();
			}
		}
	}
	
	public void supprimerFicheIncidentVoyageParId(FicheIncident _ficheIncidentVoyage) {
		// TODO Auto-generated method stub
		EntityTransaction etx = null;
		try {
				// Initialiser une transaction JPA
				etx = this.em.getTransaction();
				etx.begin();
				
				this.em.remove(_ficheIncidentVoyage);
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
	public List<FicheIncident> listeFichesMarrakech() {
		String jpqlquery = "select f from FicheIncident f where f.lieu_incident = 'Marrakech' ";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	
	
	@Override
	public List<FicheIncident> listeIncidentsCritiques() {
	 String jpqlquery = "select f from FicheIncident f where f.description_incident='Critique'";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	
	@Override
	public List<Object[]> NombreIncidentsParLieu() {
	 String jpqlquery = "select count(*) as numcr, lieu_incident from FicheIncident f where"
	 		+ " f.description_incident='Critique' group by lieu_incident";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	
	@Override
	public List<Object[]> NombreIncidentsParAgent() {
	 String jpqlquery = "select a.matricule, a.nom, Sum(f.agentDeclarant) "
	 		+ "from AgentDeclarant a, FicheIncident f "
	 		+ "where a.id= f.agentDeclarant group by f.agentDeclarant";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	
	@Override
	public List<Object[]> vehiculeCritique() {
	 String jpqlquery = "select v.id, v.codeInterne, v.immatriculation, v.dateMiseEnCirculation "
	 		+ "from Vehicule v, FicheIncident f "
	 		+ "where v.id = f.vehicule and f.description_incident = 'Critique'";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	
	@Override
	public List<Object[]> nombreIncidentCritiqueParVehicule() {
	 String jpqlquery = "select v.id, v.codeInterne, v.immatriculation, v.dateMiseEnCirculation , count(f) "
	 		+ "from FicheIncident f JOIN  f.vehicule v "
	 		+ "where  f.description_incident = 'Critique' group by v.id";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	
	@Override
	public List<Object[]> incidentTrieParDureeDesc() {
	 String jpqlquery = "select id, numero_fiche, (hour(date_declaration)-hour(date_incident))"
	 		+ ", (minute(date_declaration)-minute(date_incident)) "
	 		+ " as duree from FicheIncident order by duree DESC ";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<FicheIncident> listeLesPlusRecentIncidentAccident(){
		String jpqlquery= "SELECT f FROM FicheIncident f WHERE f.type_incident='Accident' "
				+ "ORDER BY f.date_incident DESC";
		Query query = this.em.createQuery(jpqlquery);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> frequenceIncident() {
		
		String jpqlquery = "select type_incident, count(*) as freq from FicheIncident group by type order by freq desc";
		
		Query query = this.em.createQuery(jpqlquery);
			return query.getResultList();
			
		}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> classementChauffeurs() {
		 String jpqlquery = "select c.id, c.nom, c.prenom, count(f) as nbIncident from FicheIncident f JOIN "
		 		+ " f.chauffeur c where c.id = f.chauffeur_id group by c.id order by nbIncident";
			Query query = this.em.createQuery(jpqlquery);
			return query.getResultList();
		}
	@SuppressWarnings("unchecked")
	public List<Object[]> chauffeurAucunIncident() {
		 String jpqlquery = "select c.id, c.nom, c.prenom, c.matricule "
		 		+ "from Chauffeur c  "
		 		+ "where c.id NOT IN (select distinct f.chauffeur_id from FicheIncident f)";
			Query query = this.em.createQuery(jpqlquery);
			return query.getResultList();
		}
	@SuppressWarnings("unchecked")
	public List<Object[]> tempsAttenteMaximum() {
		 String jpqlquery = "select id,numero_fiche,date_declaration,date_reprise from FicheIncident "
		 		+ " where (date_reprise - date_declaration) "
		 		+ "= (select max(date_reprise - date_declaration) from FicheIncident) ";
			Query query = this.em.createQuery(jpqlquery);
			return query.getResultList();
		}

	@Override
	public List<FicheIncident> listeIncidentRecent() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
