package de.sni.demo.database_neo4j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@Profile("Neo4j")
@ComponentScan("de.sni.demo.database_neo4j")
@EnableNeo4jRepositories("de.sni.demo.database_neo4j")
public class Neo4jConfig {
}
