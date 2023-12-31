package de.sni.database_mongodb.theme;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.episode.EpisodeService;
import de.sni.demo.businesslogic.tag.TagService;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.theme.ThemeBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MongoDBThemeBuilder implements ThemeBuilder
{
    private final EpisodeService episodeService;
    private final TagService tagService;

    @Override
    public Theme build(
            final String themeId,
            final String text,
            final String timestamp,
            final String episodeId,
            final List<String> tags,
            final List<Comment> comments)
    {
        return new MongoDBTheme(
                themeId != null ? UUID.fromString(themeId) : null,
                text,
                timestamp,
                episodeService.getById(episodeId).orElse(null),
                tags.stream()
                        .map(tagService::getById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList()),
                comments
        );
    }
}
