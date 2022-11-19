package de.sni.demo.businesslogic.episode;

import de.sni.demo.businesslogic.theme.ThemeService;
import de.sni.demo.businesslogic.theme.event.ThemeCreatedEvent;
import de.sni.demo.database.episode.Episode;
import de.sni.demo.database.theme.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EpisodeContextEventListener
{
    private final EpisodeService episodeService;
    private final ThemeService themeService;

    @Async
    @EventListener
    public void handleThemeCreatedEvent(final ThemeCreatedEvent event)
    {
        final Optional<Theme> theme = themeService.getById(event.getThemeId());
        final Optional<Episode> episode = episodeService.getById(event.getEpisodeId());

        if (theme.isEmpty() || episode.isEmpty())
        {
            return;
        }

        episode.ifPresent(episode1 -> episode1.addTheme(theme.get()));

        episodeService.save(episode.get());
    }
}
