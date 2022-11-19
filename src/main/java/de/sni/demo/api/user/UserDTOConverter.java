package de.sni.demo.api.user;

import de.sni.demo.database.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter
{
    public User convert(final CreateUserRequest request)
    {
        return new User(
                null,
                request.getName(),
                request.getPassword(),
                null,
                null);
    }
}
