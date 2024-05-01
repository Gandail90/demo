package de.sni.demo.api.user;

import de.sni.demo.businesslogic.user.User;
import de.sni.demo.businesslogic.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
        return ResponseEntity.of(
                userService.getById(userId));
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<User>> getAll()
    {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody final CreateUserRequest request)
    {
        final User created =
                userService.save(converter.convert(request));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
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
