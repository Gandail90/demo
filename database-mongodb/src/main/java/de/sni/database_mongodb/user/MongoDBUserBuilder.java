package de.sni.database_mongodb.user;

import de.sni.demo.businesslogic.comment.CommentService;
import de.sni.demo.businesslogic.theme.ThemeService;
import de.sni.demo.businesslogic.user.User;
import de.sni.demo.businesslogic.user.UserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Component
@Profile("MongoDB")
@RequiredArgsConstructor
public class MongoDBUserBuilder implements UserBuilder
{
    private final ThemeService themeService;
    private final CommentService commentService;
    @Override
    public User build(
            final String userId,
            final String name,
            final String password,
            final List<String> themesIds,
            final List<String> commentsIds)
    {
        return new MongoDBUser(
                userId,
                name,
                password,
                themesIds.stream()
                        .map(themeService::getById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList()),
                commentsIds.stream()
                        .map(commentService::getById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }
}
