package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import repository.LogementRepository;

public class Query implements GraphQLRootResolver {
    
	private LogementRepository logementRepository;

	public Query(LogementRepository logRep) {
		this.logementRepository = logRep;
		
	}
	
	public List<Logement> allLogments() {
		return logementRepository.getAllLogements();
	}
}
