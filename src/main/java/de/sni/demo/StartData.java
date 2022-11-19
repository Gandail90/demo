package de.sni.demo;

import de.sni.demo.businesslogic.UserService;
import de.sni.demo.database.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartData
{
    private final UserService userService;

    @EventListener
    public void handle(final ApplicationStartedEvent event)
    {
        log.info("Started Event Catched");
        addFirstUsers();
    }

    private void addFirstUsers()
    {
        if (userService.getAll().isEmpty())
        {
            userService.save(new User(UUID.randomUUID().toString(), "Steffen", "Test", new ArrayList<>(), new ArrayList<>()));
        }
    }
}
