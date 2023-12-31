package de.sni.database_mongodb.theme;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.theme.Theme;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Document(collection = "theme")
public class MongoDBTheme extends AbstractAggregateRoot<MongoDBTheme> implements Theme
{
    @Id
    private UUID themeId;

    @Setter
    private String text;

    @Setter
    private String timestamp;

    @DBRef
    private Episode episode;

    @DBRef
    private List<Tag> tag;

    @DBRef
    private List<Comment> comments;

    @Override
    public String getId()
    {
        if (themeId == null)
        {
            return null;
        }
        return themeId.toString();
    }

    @Override
    public void setThemeId(final String themeId)
    {
        this.themeId = UUID.fromString(themeId);
    }

    @Override
    public void setEpisodeId(final String episodeId)
    {

    }

    @Override
    public void addTag(final String tagId)
    {

    }

    @Override
    public void addTag(final Tag tag)
    {

    }

    @Override
    public void setTagsIds(final List<String> tagIds)
    {

    }

    @Override
    public void setTags(final List<Tag> tags)
    {

    }

    @Override
    public void setComments(final List<Comment> comments)
    {

    }

    @Override
    public void addComment(final Comment comment)
    {

    }
}
