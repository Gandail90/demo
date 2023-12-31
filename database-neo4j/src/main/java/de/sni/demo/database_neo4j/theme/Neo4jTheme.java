package de.sni.demo.database_neo4j.theme;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.theme.event.ThemeCreatedEvent;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Node
@Getter
@Setter
@AllArgsConstructor
public class Neo4jTheme extends AbstractAggregateRoot<Neo4jTheme> implements Theme
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

    @Override
    public String getId() {
        return themeId;
    }

    public void addTag(final String tagId)
    {
        if (tagIds == null)
        {
            tagIds = new ArrayList<>();
        }

        tagIds.add(tagId);
    }

    @Override
    public void addTag(final Tag tag)
    {
        addTag(tag.getTagId());
    }

    @Override
    public void setTagsIds(final List<String> tagIds)
    {
        this.tagIds = tagIds;
    }

    @Override
    public void setTags(final List<Tag> tags)
    {
        tags.forEach(this::addTag);
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
