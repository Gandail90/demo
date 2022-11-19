package de.sni.demo.businesslogic.episode;

import de.sni.demo.database.episode.Episode;
import de.sni.demo.database.episode.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    public Episode save(final Episode episode)
    {
        return episodeRepository.save(episode);
    }

    public void delete(final String episodeId)
    {
        episodeRepository.deleteById(episodeId);
    }

    public Optional<Episode> getById(final String episodeId)
    {
        return episodeRepository.findById(episodeId);
    }

    public List<Episode> getAll()
    {
        return episodeRepository.findAll();
    }
}
