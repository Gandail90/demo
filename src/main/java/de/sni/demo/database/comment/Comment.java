package de.sni.demo.database.comment;

import de.sni.demo.businesslogic.comment.event.CommentCreatedEvent;
import de.sni.demo.database.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Node
@Getter
@AllArgsConstructor
public class Comment extends AbstractAggregateRoot<Comment>
{
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String commentId;

    private String text;

    @Setter
    private LocalDateTime timestamp;

    @Relationship(type = "CREATOR", direction = Relationship.Direction.INCOMING)
    private User creator;

    private String themeId;

    @Relationship(type = "LIKE", direction = Relationship.Direction.INCOMING)
    private List<User> likes;

    public void addLike(final User user)
    {
        if (likes == null)
        {
            likes = new ArrayList<>();
        }

        likes.add(user);
    }

    @DomainEvents
    protected Collection<Object> domainEvents()
    {
        return List.of(
                new CommentCreatedEvent(
                        commentId,
                        themeId));
    }
}
