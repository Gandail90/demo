package de.sni.database_mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("MongoDB")
@EnableMongoRepositories("de.sni.demo.database_mongodb")
@ComponentScan("de.sni.demo.database_mongodb")
public class MongoDBConfig {

//    @Bean
//    public MongoClient mongo() throws Exception {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/demo");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applicationName("demo")
//                .uuidRepresentation(UuidRepresentation.STANDARD)
//                .applyConnectionString(connectionString).build();
//        return MongoClients.create(mongoClientSettings);
//    }
}
