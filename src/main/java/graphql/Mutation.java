package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import repository.LogementRepository;

public class Mutation implements GraphQLRootResolver {

	 private LogementRepository logementRepository;
	 
	 public Mutation(LogementRepository logRep) {
		 this.logementRepository = logRep;
		 
	 }
	 
	 public Logement createLogement(int reference, String adresse) {
		 Logement logement = new Logement(reference,adresse);
		 logementRepository.saveLogement(logement);
		 return logement;
	 }
}
