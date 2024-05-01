package de.sni.demo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import de.sni.database_mongodb.comment.MongoDBCommentBuilder;
import de.sni.demo.businesslogic.comment.CommentBuilder;
import org.bson.UuidRepresentation;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("MongoDB")
@EntityScan("de.sni.database_mongodb")
@ComponentScan("de.sni.database_mongodb")
@EnableMongoRepositories("de.sni.database_mongodb")
public class MongoConfig
{
    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/demo");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applicationName("demo")
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public CommentBuilder commentBuilder() {
        return new MongoDBCommentBuilder();
    }
}
