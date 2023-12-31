package de.sni.demo.businesslogic.user;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserBuilder
{
    User build(
            final String userId,
            final String name,
            final String password,
            final List<String> themesIds,
            final List<String> commentsIds);
}
