package de.sni.demo.database_neo4j.theme;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.theme.ThemeBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
@Profile("Neo4j")
public class Neo4jThemeBuilder implements ThemeBuilder
{
    @Override
    public Theme build(
            final String themeId,
            final String text,
            final String timestamp,
            final String episodeId,
            final List<String> tags,
            final List<Comment> comments
    )
    {
        return new Neo4jTheme(
                themeId,
                text,
                timestamp,
                episodeId,
                tags,
                comments
        );
    }
}
