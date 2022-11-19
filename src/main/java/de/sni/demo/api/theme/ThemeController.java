package de.sni.demo.api.theme;

import de.sni.demo.businesslogic.tag.TagService;
import de.sni.demo.businesslogic.theme.ThemeService;
import de.sni.demo.database.tag.Tag;
import de.sni.demo.database.theme.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller(value = "theme")
@RequestMapping(path = "theme")
@RequiredArgsConstructor
public class ThemeController
{
    private final ThemeService themeService;
    private final ThemeDTOConverter converter;

    private final TagService tagService;

    @GetMapping(path = "{themeId}")
    public ResponseEntity<Theme> getById(
            @PathVariable(name = "themeId") final String themeId)
    {
        return ResponseEntity.of(themeService.getById(themeId));
    }

    @PostMapping
    public ResponseEntity<Theme> create(@RequestBody final CreateThemeDTO theme)
    {
        return ResponseEntity.of(
                Optional.of(
                        themeService.save(
                                converter.convert(theme))));
    }

    @PostMapping(path = "{themeId}/tagging/{tagId}")
    public ResponseEntity<Theme> tagTheme(
            @PathVariable("themeId") final String themeId,
            @PathVariable("tagId") final String tagId)
    {
        final Optional<Theme> theme = themeService.getById(themeId);
        final Optional<Tag> tag = tagService.getById(tagId);

        if (theme.isEmpty() || tag.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        theme.ifPresent(theme1 -> theme1.addTag(tag.get().getTagId()));

        return ResponseEntity.ok(themeService.save(theme.get()));
    }

    @DeleteMapping(path = "{themeId}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "themeId") final String themeId)
    {
        try
        {
            themeService.delete(themeId);
            return ResponseEntity.ok().build();
        } catch (final Exception exception)
        {
            exception.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
