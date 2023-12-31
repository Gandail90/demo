package de.sni.demo.api.episode;

import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.episode.EpisodeBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class EpisodeDTOConverter
{
    private final EpisodeBuilder episodeBuilder;

    public Episode convert(final CreateEpisodeRequest request) throws MalformedURLException
    {
        return episodeBuilder
                .build(
                        null,
                        request.getName(),
                        new URL(request.getLink()),
                        null);
    }
}
