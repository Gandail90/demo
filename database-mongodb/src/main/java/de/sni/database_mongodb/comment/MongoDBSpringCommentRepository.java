package de.sni.database_mongodb.comment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoDBSpringCommentRepository extends MongoRepository<MongoDBComment, UUID>
{
}
