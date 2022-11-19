package de.sni.demo.api.user;

import de.sni.demo.businesslogic.UserService;
import de.sni.demo.database.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller(value = "user")
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;
    private final UserDTOConverter converter;

    @GetMapping(path = "{userId}")
    public ResponseEntity<User> getById(
            @PathVariable(name = "userId") final String userId)
    {
        return ResponseEntity.of(userService.getById(userId));
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<User>> getAll()
    {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody final CreateUserRequest request)
    {
        return ResponseEntity.of(
                Optional.of(
                        userService.save(
                                converter.convert(request))));
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "userId") final String userId)
    {
        try
        {
            userService.delete(userId);
            return ResponseEntity.ok().build();
        } catch (final Exception exception)
        {
            exception.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
