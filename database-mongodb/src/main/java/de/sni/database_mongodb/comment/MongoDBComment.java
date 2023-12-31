package de.sni.database_mongodb.comment;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.event.CommentCreatedEvent;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Document(collection = "comment")
public class MongoDBComment extends AbstractAggregateRoot<MongoDBComment> implements Comment
{
    @Id
    private UUID commentId;

    private String text;

    @Setter
    private LocalDateTime timestamp;

    @DBRef
    private User creator;

    @DBRef
    private Theme theme;

    @DBRef
    private List<User> likedUser;

    public void addLike(final User user)
    {
        likedUser.add(user);
    }

    @Override
    public List<User> getLikedUsers()
    {
        return likedUser;
    }

    @Override
    @DomainEvents
    protected Collection<Object> domainEvents()
    {
        return List.of(
                new CommentCreatedEvent(
                        commentId.toString(),
                        theme.getId()));
    }
}

