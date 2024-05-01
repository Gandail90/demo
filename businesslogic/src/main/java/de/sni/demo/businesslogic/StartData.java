package de.sni.demo.businesslogic;

import de.sni.demo.businesslogic.user.UserBuilder;
import de.sni.demo.businesslogic.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class StartData
{
    private final UserService userService;
    private final UserBuilder userBuilder;

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
            userService.save(
                    userBuilder.build(
                            UUID.randomUUID().toString(),
                            "Steffen",
                            "Test",
                            new ArrayList<>(),
                            new ArrayList<>()));
        }
    }
}
