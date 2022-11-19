package de.sni.demo.api.episode;

import de.sni.demo.database.episode.Episode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class EpisodeDTOConverter
{
    public Episode convert(final CreateEpisodeRequest request) throws MalformedURLException
    {
        return new Episode(
                null,
                request.getName(),
                new URL(request.getLink()),
                null);
    }
}
