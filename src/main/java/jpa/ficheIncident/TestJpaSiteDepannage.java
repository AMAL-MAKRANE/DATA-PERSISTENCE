package jpa.ficheIncident;

import java.util.ArrayList;
import java.util.List;

import jpa.ficheIncident.dao.FicheIncident;
import jpa.ficheIncident.dao.SiteDepannage;
import jpa.ficheIncident.dao.SiteDepannageDao;
import jpa.ficheIncident.dao.SiteDepannageDaoFactory;
import jpa.ficheIncident.dao.SiteDepannageDaoJpaImpl;
import jpa.ficheIncident.dao.Vehicule;
import jpa.ficheIncident.dao.VehiculeDao;
import jpa.ficheIncident.dao.VehiculeDaoFactory;

public class TestJpaSiteDepannage {
	public static void main(String[] args) {
		//TestJpaSiteDepannage.testerCrudSite(SiteDepannageDaoFactory.JPA_DAO);
		//TestJpaSiteDepannage.testerSite(SiteDepannageDaoFactory.JPA_DAO);
		
	}
	
	
	private static void testerSite(String typeDao) {
		SiteDepannageDao siteDao =SiteDepannageDaoFactory.getSiteDao(typeDao);
		List<Object[]> listS = siteDao.listerSite();
		for(Object[] i: listS) {
			System.out.println("#-id: " +i[0] +"  ||  " +"code site: " + i[1]  
					+"  ||  " +"description: "+i[2] +"  ||  " +"libellé: "+i[3]);
			
		}
	}

	

	





	private static void testerCrudSite(String typeDao) {
		try {
			SiteDepannageDao siteDao =SiteDepannageDaoFactory.getSiteDao(typeDao);
			// Test Insertion
			SiteDepannage site1 = new SiteDepannage();
			site1.setCode("1");
			site1.setDescription("desc1");
			site1.setLibelle("lib1");
			siteDao.insererSite(site1);
			
			SiteDepannage site2 = new SiteDepannage();
			site2.setCode("2");
			site2.setDescription("desc2");
			site2.setLibelle("lib2");
			siteDao.insererSite(site2);
			
			SiteDepannage site3 = new SiteDepannage();
			site3.setCode("3");
			site3.setDescription("desc3");
			site3.setLibelle("lib3");
			siteDao.insererSite(site3);
			
			SiteDepannage site4 = new SiteDepannage();
			site4.setCode("4");
			site4.setDescription("desc4");
			site4.setLibelle("lib4");
			siteDao.insererSite(site4);
			
			SiteDepannage site5 = new SiteDepannage();
			site5.setCode("5");
			site5.setDescription("desc5");
			site5.setLibelle("lib4");
			siteDao.insererSite(site5);
		
			
			// Test Lister
			List<SiteDepannage> listeSite = new ArrayList<>();
			listeSite = siteDao. rechercherTousLesSites();
			for (SiteDepannage s : listeSite) {
				System.out.println("#- id:" + s.getId().longValue() + ",code site:" + s.getCode() + ",description:"
						+ s.getDescription()+ ",libelle:" + s.getLibelle());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		

	}	
