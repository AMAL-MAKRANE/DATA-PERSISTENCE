package jpa.ficheIncident.dao;
import java.util.List;

public interface SiteDepannageDao {
	void insererSite(SiteDepannage _site);
	
	List<SiteDepannage> rechercherTousLesSites();
	
	SiteDepannage rechercherSite(Long _id);
	
	void modifierSite(SiteDepannage _site);
	
	void supprimerSite(SiteDepannage _site);
	
	List<Object[]> listerSite();

	
	
}
