package de.sni.demo.database_neo4j.episode;

import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.episode.EpisodeBuilder;
import de.sni.demo.businesslogic.theme.Theme;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
public class Neo4jEpisodeBuilder implements EpisodeBuilder
{
    @Override
    public Episode build(final String episodeId, final String name, final URL link, final List<Theme> themes)
    {
        return new Neo4jEpisode(
                episodeId,
                name,
                link,
                themes);
    }
}
