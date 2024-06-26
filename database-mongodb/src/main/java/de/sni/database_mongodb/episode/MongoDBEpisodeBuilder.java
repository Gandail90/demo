package de.sni.database_mongodb.episode;

import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.episode.EpisodeBuilder;
import de.sni.demo.businesslogic.theme.Theme;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.UUID;

@Primary
@Component
@Profile("MongoDB")
public class MongoDBEpisodeBuilder implements EpisodeBuilder
{
    @Override
    public Episode build(
            final String episodeId,
            final String name,
            final URL link,
            final List<Theme> themes)
    {

        return new MongoDBEpisode(
                episodeId != null ? UUID.fromString(episodeId) : null,
                name,
                link,
                themes
        );
    }
}
