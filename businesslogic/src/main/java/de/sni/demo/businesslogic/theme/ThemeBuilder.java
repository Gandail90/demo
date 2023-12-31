package de.sni.demo.businesslogic.theme;

import de.sni.demo.businesslogic.comment.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ThemeBuilder
{
    Theme build(
            final String themeId,
            final String text,
            final String timestamp,
            final String episodeId,
            final List<String> tags,
            final List<Comment> comments
    );
}
