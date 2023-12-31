package de.sni.demo.businesslogic.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserRepository
{
    User save(final User user);

    void deleteById(final String userId);

    Optional<User> findById(final String userId);

    List<User> findAll();
}
