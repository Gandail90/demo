package de.sni.database_mongodb.comment;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.CommentBuilder;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@Profile("MongoDB")
public class MongoDBCommentBuilder implements CommentBuilder
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

        return new MongoDBComment(
                commentId != null ? UUID.fromString(commentId) : null,
                text,
                timestamp,
                creator,
                theme,
                likes

        );
    }
}
