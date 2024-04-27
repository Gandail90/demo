package de.sni.demo.database_neo4j.comment;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.CommentBuilder;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Primary
@Component
@Profile("Neo4j")
public class Neo4jCommentBuilder implements CommentBuilder
{
    @Override
    public Comment build(
            final String commentId,
            final String text,
            final LocalDateTime timestamp,
            final User creator,
            final Theme theme,
            final List<User> likes)
    {
        return new Neo4jComment(
                commentId,
                text,
                timestamp,
                creator,
                theme,
                likes);
    }
}
