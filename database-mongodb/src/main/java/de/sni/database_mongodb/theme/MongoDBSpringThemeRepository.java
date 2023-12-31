package de.sni.database_mongodb.theme;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoDBSpringThemeRepository extends MongoRepository<MongoDBTheme, UUID>
{
}
