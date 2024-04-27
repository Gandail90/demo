package de.sni.database_mongodb.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MongoDBSpringUserRepository extends MongoRepository<MongoDBUser, String>
{
}
