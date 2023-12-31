package de.sni.database_mongodb.episode;

import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.episode.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Primary
@Component
@Profile("MongoDB")
@RequiredArgsConstructor
public class MongoDBEpisodeRepository implements EpisodeRepository
{

    private final MongoDBSpringEpisodeRepository repository;

    @Override
    public Episode save(final Episode episode)
    {
        return repository.save((MongoDBEpisode) episode);
    }

    @Override
    public void deleteById(final String episodeId)
    {

        if (episodeId == null)
        {
            return;
        }
        repository.deleteById(UUID.fromString(episodeId));
    }

    @Override
    public Optional<Episode> findById(final String episodeId)
    {

        if (episodeId == null)
        {
            return Optional.empty();
        }
        return repository.findById(UUID.fromString(episodeId))
                .map(Episode.class::cast);
    }

    @Override
    public List<Episode> findAll()
    {
        return repository.findAll().stream()
                .map(Episode.class::cast)
                .collect(Collectors.toList());
    }
}
