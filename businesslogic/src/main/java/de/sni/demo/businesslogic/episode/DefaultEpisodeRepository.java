package de.sni.demo.businesslogic.episode;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultEpisodeRepository implements EpisodeRepository
{
    @Override
    public Episode save(final Episode episode)
    {
        throw new RuntimeException("DefaultEpisodeRepository should not be used");
    }

    @Override
    public void deleteById(final String episodeId)
    {
        throw new RuntimeException("DefaultEpisodeRepository should not be used");
    }

    @Override
    public Optional<Episode> findById(final String episodeId)
    {
        throw new RuntimeException("DefaultEpisodeRepository should not be used");
    }

    @Override
    public List<Episode> findAll()
    {
        throw new RuntimeException("DefaultEpisodeRepository should not be used");
    }
}
