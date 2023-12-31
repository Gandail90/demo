package de.sni.database_mongodb.tag;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoDBSpringTagRepository extends MongoRepository<MongoDBTag, UUID>
{
}
