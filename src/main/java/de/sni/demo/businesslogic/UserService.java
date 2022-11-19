package de.sni.demo.businesslogic;

import de.sni.demo.database.user.User;
import de.sni.demo.database.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public Optional<User> getById(final String userId)
    {
        return userRepository.findById(userId);
    }

    @Transactional(readOnly = true)
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
}
