package de.sni.demo.database_neo4j.user;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jSpringUserRepository extends Neo4jRepository<Neo4jUser, String> {
}
