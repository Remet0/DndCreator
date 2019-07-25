package com.dnd.graphql;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQLProvider {

		private GraphQL graphQL;
		
		@Autowired
		SpellDataFetchers spellDataFetchers;
		
		@Autowired
		DndClassDataFetchers dndClassDataFetchers;
		
		@PostConstruct
		public void init() throws IOException {
			URL url = Resources.getResource("graphqlschemas/schema.graphqls");
			String sdl = Resources.toString(url, Charsets.UTF_8);
			URL typeDefs = Resources.getResource("graphqlschemas/typeDefs.graphqls");
			sdl = sdl + Resources.toString(typeDefs, Charsets.UTF_8);
			GraphQLSchema graphQLSchema = buildSchema(sdl);
			this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
		}
	
		private GraphQLSchema buildSchema(String sdl) {
			TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
			RuntimeWiring runtimeWiring = buildWiring();
			SchemaGenerator schemaGenerator = new SchemaGenerator();
			return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
		}

		private RuntimeWiring buildWiring() {
			
			
			return RuntimeWiring.newRuntimeWiring()
					//Spell Queries and Mutations
					.type(newTypeWiring("Query").dataFetcher("allSpells",
							spellDataFetchers.getAllSpellsDataFetcher()))
					.type(newTypeWiring("Query").dataFetcher("spellByName",
							spellDataFetchers.getSpellByNameDataFetcher()))
					.type(newTypeWiring("Query").dataFetcher("spellById",
							spellDataFetchers.getSpellByIdDataFetcher()))
					.type(newTypeWiring("Mutation").dataFetcher("createOrUpdateSpell",
							spellDataFetchers.createSpellDataFetcher()))
					.type(newTypeWiring("Mutation").dataFetcher("removeSpell",
							spellDataFetchers.removeSpellDataFetcher()))
					
					//DndClass Queries and Mutations
					.type(newTypeWiring("Query").dataFetcher("allClasses",
							dndClassDataFetchers.getAllDndClassesDataFetcher()))
					.type(newTypeWiring("Query").dataFetcher("classByName",
							dndClassDataFetchers.getClassByNameDataFetcher()))
					.type(newTypeWiring("Query").dataFetcher("classById",
							dndClassDataFetchers.getClassByIdDataFetcher()))
					.type(newTypeWiring("Mutation").dataFetcher("createOrUpdateClass",
							dndClassDataFetchers.createClassDataFetcher()))
					.type(newTypeWiring("Mutation").dataFetcher("removeClass",
							dndClassDataFetchers.removeClassDataFetcher()))
					.build();
		}
		
		@Bean
		public GraphQL graphQL() {
			return graphQL;
		}
}
