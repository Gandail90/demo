package de.sni.demo.api.episode;

import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.episode.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

@Controller(value = "episode")
@RequestMapping(path = "episode")
@RequiredArgsConstructor
public class EpisodeController
{
    private final EpisodeService episodeService;
    private final EpisodeDTOConverter converter;

    @GetMapping(path = "{episodeId}")
    public ResponseEntity<Episode> getById(
            @PathVariable(name = "episodeId") final String episodeId)
    {
        return ResponseEntity.of(episodeService.getById(episodeId));
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Episode>> getAll()
    {
        return ResponseEntity.ok(episodeService.getAll());
    }

    @PostMapping
    public ResponseEntity<Episode> create(@RequestBody final CreateEpisodeRequest request) throws MalformedURLException
    {
        return ResponseEntity.of(
                Optional.of(
                        episodeService.save(
                                converter.convert(request))));
    }

    @DeleteMapping(path = "{episodeId}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "episodeId") final String episodeId)
    {
        try
        {
            episodeService.delete(episodeId);
            return ResponseEntity.ok().build();
        } catch (final Exception exception)
        {
            exception.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
