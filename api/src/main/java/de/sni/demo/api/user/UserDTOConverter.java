package de.sni.demo.api.user;

import de.sni.demo.businesslogic.user.User;
import de.sni.demo.businesslogic.user.UserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class UserDTOConverter
{
    private final UserBuilder userBuilder;

    public User convert(final CreateUserRequest request)
    {
        return userBuilder
                .build(
                        null,
                        request.getName(),
                        request.getPassword(),
                        new ArrayList<>(),
                        new ArrayList<>());
    }
}
