package de.sni.demo.database_neo4j.comment;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jSpringCommentRepository extends Neo4jRepository<Neo4jComment, String>
{
}
