package de.sni.demo.database_neo4j.user;

import de.sni.demo.businesslogic.user.User;
import de.sni.demo.businesslogic.user.UserBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
@Profile("Neo4j")
public class Neo4jUserBuilder implements UserBuilder
{
    @Override
    public User build(
            final String userId,
            final String name,
            final String password,
            final List<String> themesIds,
            final List<String> commentsIds)
    {
        return new Neo4jUser(
                userId,
                name,
                password,
                themesIds,
                commentsIds);
    }
}
