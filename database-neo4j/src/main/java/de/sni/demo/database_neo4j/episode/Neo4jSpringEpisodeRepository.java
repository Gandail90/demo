package de.sni.demo.database_neo4j.episode;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jSpringEpisodeRepository extends Neo4jRepository<Neo4jEpisode, String>
{
}
