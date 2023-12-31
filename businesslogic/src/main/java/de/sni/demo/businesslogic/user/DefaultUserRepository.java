package de.sni.demo.businesslogic.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultUserRepository implements UserRepository
{
    @Override
    public User save(final User user)
    {
        throw new RuntimeException("DefaultUserRepository should not be used");
    }

    @Override
    public void deleteById(final String userId)
    {
        throw new RuntimeException("DefaultUserRepository should not be used");
    }

    @Override
    public Optional<User> findById(final String userId)
    {
        throw new RuntimeException("DefaultUserRepository should not be used");
    }

    @Override
    public List<User> findAll()
    {
        throw new RuntimeException("DefaultUserRepository should not be used");
    }
}
