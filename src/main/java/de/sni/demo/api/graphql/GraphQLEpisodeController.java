package de.sni.demo.api.graphql;

import de.sni.demo.api.episode.CreateEpisodeRequest;
import de.sni.demo.api.episode.EpisodeDTOConverter;
import de.sni.demo.businesslogic.episode.EpisodeService;
import de.sni.demo.database.episode.Episode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GraphQLEpisodeController
{
    private final EpisodeService service;
    private final EpisodeDTOConverter converter;

    @QueryMapping
    public Episode getEpisodeById(@Argument final String episodeId)
    {
        log.info("###################### episodeById: " + episodeId);
        return service.getById(episodeId)
                .orElse(null);
    }

    @QueryMapping
    public List<Episode> getAllEpisodes()
    {
        return service.getAll();
    }

    @MutationMapping
    public Episode createEpisode(@Argument final CreateEpisodeRequest request) throws MalformedURLException
    {
        return service.save(converter.convert(request));
    }

    @MutationMapping
    public Boolean deleteEpisode(@Argument final String episodeId)
    {
        try {
            service.delete(episodeId);
            return true;
        } catch (final Exception exception)
        {
            return false;
        }
    }

    @SubscriptionMapping
    public Flux<Episode> subscribeToEpisodes()
    {
        return Flux.fromIterable(service.getAll());
    }
}
