package de.sni.demo.database_neo4j.tag;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jSpringTagRepository extends Neo4jRepository<Neo4jTag, String>
{
}
