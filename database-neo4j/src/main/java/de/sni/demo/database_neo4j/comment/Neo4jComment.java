package de.sni.demo.database_neo4j.comment;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.event.CommentCreatedEvent;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;
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
public class Neo4jComment extends AbstractAggregateRoot<Neo4jComment> implements Comment
{
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String commentId;

    private String text;

    @Setter
    private LocalDateTime timestamp;

    @Relationship(type = "CREATOR", direction = Relationship.Direction.INCOMING)
    private User creator;

    @Relationship(type = "THEME", direction = Relationship.Direction.INCOMING)
    private Theme theme;

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

    @Override
    public List<User> getLikedUsers() {
        return likes;
    }

    @Override
    @DomainEvents
    public Collection<Object> domainEvents()
    {
        return List.of(
                new CommentCreatedEvent(
                        commentId,
                        theme.getId()));
    }
}
