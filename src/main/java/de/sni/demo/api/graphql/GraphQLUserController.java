package de.sni.demo.api.graphql;

import de.sni.demo.api.user.CreateUserRequest;
import de.sni.demo.api.user.UserDTOConverter;
import de.sni.demo.businesslogic.UserService;
import de.sni.demo.database.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GraphQLUserController
{
    private final UserService service;
    private final UserDTOConverter converter;

    @MutationMapping
    public User createUser(@Argument final CreateUserRequest request)
    {
        log.info("##################### create User: " + request);
        return service.save(converter.convert(request));
    }

    @MutationMapping
    public Boolean deleteUser(@Argument final String userId)
    {
        log.info("####################### deleteUser: " + userId);
        service.delete(userId);

        return true;
    }

    @MutationMapping
    public User renameUser(@Argument final String userId,
                           @Argument final String newName)
    {
        final Optional<User> user = service.getById(userId);

        user.ifPresent(user1 -> user1.setName(newName));

        return user
                .map(service::save)
                .orElse(null);
    }

    @QueryMapping
    public User getUserById(@Argument final String userId)
    {
        return service.getById(userId).orElse(null);
    }

    @QueryMapping
    public List<User> getAllUser()
    {
        return service.getAll();
    }
}
