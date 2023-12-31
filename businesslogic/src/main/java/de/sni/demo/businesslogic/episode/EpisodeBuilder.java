package de.sni.demo.businesslogic.episode;

import de.sni.demo.businesslogic.theme.Theme;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
public interface EpisodeBuilder
{
    Episode build(
            final String episodeId,
            final String name,
            final URL link,
            final List<Theme> themes);
}
