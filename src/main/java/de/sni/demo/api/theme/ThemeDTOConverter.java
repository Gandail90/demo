package de.sni.demo.api.theme;

import de.sni.demo.database.theme.Theme;
import org.springframework.stereotype.Component;

@Component
public class ThemeDTOConverter
{

    Theme convert(final CreateThemeDTO dto)
    {
        return new Theme(
                dto.getThemeId(),
                dto.getText(),
                dto.getTimestamp(),
                dto.getEpisodeId(),
                dto.getTagIds(),
                null);
    }
}
