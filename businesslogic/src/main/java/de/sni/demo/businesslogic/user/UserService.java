package de.sni.demo.businesslogic.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(final User user)
    {
        return userRepository.save(user);
    }

    public void delete(final String userId)
    {
        userRepository.deleteById(userId);
    }

    public Optional<User> getById(final String userId)
    {
        return userRepository.findById(userId);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }
}
