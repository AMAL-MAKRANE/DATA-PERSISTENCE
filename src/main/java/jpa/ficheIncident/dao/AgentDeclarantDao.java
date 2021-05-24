package jpa.ficheIncident.dao;

import java.util.List;

public interface AgentDeclarantDao {
	void insererAgentDeclarant(AgentDeclarant _agentDeclarant);
	List<AgentDeclarant> rechercherTousLesAgentDeclarants();
	AgentDeclarant rechercherAgentDeclarantParId(Long _id);
	void modifierAgentDeclarant(AgentDeclarant _agentDeclarant);
	void supprimerAgentDeclarantParId(AgentDeclarant _agentDeclarant);
}
