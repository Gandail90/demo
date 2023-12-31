package de.sni.demo.database_neo4j.episode;

import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.episode.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
@Profile("Neo4j")
@RequiredArgsConstructor
public class Neo4jEpisodeRepository implements EpisodeRepository
{
    private final Neo4jSpringEpisodeRepository repository;

    @Override
    public Episode save(final Episode episode)
    {
        return repository.save((Neo4jEpisode) episode);
    }

    @Override
    public void deleteById(final String episodeId)
    {
        repository.deleteById(episodeId);
    }

    @Override
    public Optional<Episode> findById(final String episodeId)
    {
        return repository.findById(episodeId)
                .map(Episode.class::cast);
    }

    @Override
    public List<Episode> findAll()
    {
        return repository.findAll().stream()
                .map(Episode.class::cast)
                .toList();
    }
}
