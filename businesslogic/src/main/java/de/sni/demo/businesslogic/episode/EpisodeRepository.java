package de.sni.demo.businesslogic.episode;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EpisodeRepository
{
    Episode save(final Episode episode);

    void deleteById(final String episodeId);

    Optional<Episode> findById(final String episodeId);

    List<Episode> findAll();
}
