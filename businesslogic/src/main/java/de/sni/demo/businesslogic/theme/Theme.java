package de.sni.demo.businesslogic.theme;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.tag.Tag;

import java.util.List;

public interface Theme
{
    String getId();

    void setThemeId(final String themeId);

    void setText(final String text);

    void setTimestamp(final String timestamp);

    void setEpisodeId(final String episodeId);

    void addTag(final String tagId);

    void addTag(final Tag tag);

    void setTagsIds(final List<String> tagIds);

    void setTags(final List<Tag> tags);

    void setComments(final List<Comment> comments);

    void addComment(final Comment comment);
}
