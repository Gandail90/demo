package de.sni.demo.database_neo4j.user;

import de.sni.demo.businesslogic.user.User;
import de.sni.demo.businesslogic.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
@Profile("Neo4j")
@RequiredArgsConstructor
public class Neo4jUserRepository implements UserRepository
{
    private final Neo4jSpringUserRepository repository;

    @Override
    public User save(final User user)
    {
        return repository.save((Neo4jUser) user);
    }

    @Override
    public void deleteById(final String userId)
    {
        repository.deleteById(userId);
    }

    @Override
    public Optional<User> findById(final String userId)
    {
        return repository.findById(userId).map(User.class::cast);
    }

    @Override
    public List<User> findAll()
    {
        return repository.findAll().stream()
                .map(User.class::cast)
                .toList();
    }
}
