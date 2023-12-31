package de.sni.database_mongodb.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoDBSpringUserRepository extends MongoRepository<MongoDBUser, UUID>
{
}
