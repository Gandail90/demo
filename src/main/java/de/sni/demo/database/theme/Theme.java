package de.sni.demo.database.theme;

import de.sni.demo.businesslogic.theme.event.ThemeCreatedEvent;
import de.sni.demo.database.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Node
@Getter
@AllArgsConstructor
public class Theme extends AbstractAggregateRoot<Theme>
{
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String themeId;

    private String text;

    private String timestamp;

    private String episodeId;

    private List<String> tagIds;

    @Relationship(type = "COMMENT_OF", direction = Relationship.Direction.OUTGOING)
    private List<Comment> comments;

    public void addTag(final String tagId)
    {
        if (tagIds == null)
        {
            tagIds = new ArrayList<>();
        }

        tagIds.add(tagId);
    }

    public void addComment(final Comment comment)
    {
        if (comment == null)
        {
            comments = new ArrayList<>();
        }

        comments.add(comment);
    }

    @DomainEvents
    protected Collection<Object> domainEvents()
    {
        return List.of(
                new ThemeCreatedEvent(
                        themeId,
                        episodeId,
                        tagIds));
    }
}
