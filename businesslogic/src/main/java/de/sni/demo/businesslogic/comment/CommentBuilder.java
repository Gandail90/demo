package de.sni.demo.businesslogic.comment;

import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface CommentBuilder
{
    Comment build(
            final String commentId,
            final String text,
            final LocalDateTime timestamp,
            final User creator,
            final Theme theme,
            final List<User> likes);
}
