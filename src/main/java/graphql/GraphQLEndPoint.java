package graphql;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;

import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndPoint extends SimpleGraphQLServlet {

	public GraphQLEndPoint() {
		super(buildSchema());
		// TODO Auto-generated constructor stub
	}

	private static GraphQLSchema buildSchema() {
		LogementRepository logementRep = new LogementRepository();
		return SchemaParser.newParser().file("schema.graphql")
				.resolvers(new Query(logementRep),
						    new Mutation(logementRep))
				.build()
				.makeExecutableSchema();
	}
	

}
