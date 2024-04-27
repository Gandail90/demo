package de.sni.database_mongodb.user;

import de.sni.demo.businesslogic.user.User;
import de.sni.demo.businesslogic.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Component
@Profile("MongoDB")
@RequiredArgsConstructor
public class MongoDBUserRepository implements UserRepository
{
    private final MongoDBSpringUserRepository repository;

    @Override
    public User save(final User user)
    {
        return repository.save((MongoDBUser) user);
    }

    @Override
    public void deleteById(final String userId)
    {
        if (userId == null)
        {
            return;
        }

        repository.deleteById(userId);
    }

    @Override
    public Optional<User> findById(final String userId)
    {
        if (userId == null)
        {
            return Optional.empty();
        }

        return repository.findById(userId)
                .map(User.class::cast);
    }

    @Override
    public List<User> findAll()
    {
        return repository.findAll().stream()
                .map(User.class::cast)
                .collect(Collectors.toList());
    }
}
