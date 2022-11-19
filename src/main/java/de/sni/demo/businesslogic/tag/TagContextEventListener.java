package de.sni.demo.businesslogic.tag;

import de.sni.demo.businesslogic.theme.ThemeService;
import de.sni.demo.businesslogic.theme.event.ThemeCreatedEvent;
import de.sni.demo.database.tag.Tag;
import de.sni.demo.database.theme.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TagContextEventListener
{
    private final TagService tagService;
    private final ThemeService themeService;

    @Async
    @EventListener
    public void handleThemeCreatedEvent(final ThemeCreatedEvent event)
    {
        final Optional<Theme> theme = themeService.getById(event.getThemeId());
        final List<Tag> tags =
                event.getTagIds().stream()
                        .map(tagService::getById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .toList();

        if (theme.isEmpty()) {
            return;
        }

        tags.forEach(tag -> tag.addTheme(theme.get()));
        tags.forEach(tagService::save);
    }
}
