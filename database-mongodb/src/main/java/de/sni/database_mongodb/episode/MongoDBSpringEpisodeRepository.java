package de.sni.database_mongodb.episode;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoDBSpringEpisodeRepository extends MongoRepository<MongoDBEpisode, UUID>
{
}
