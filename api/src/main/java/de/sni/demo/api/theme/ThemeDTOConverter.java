package de.sni.demo.api.theme;

import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.theme.ThemeBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ThemeDTOConverter
{
    private final ThemeBuilder themeBuilder;

    Theme convert(final CreateThemeDTO dto)
    {
        return themeBuilder.build(
                dto.getThemeId(),
                dto.getText(),
                dto.getTimestamp(),
                dto.getEpisodeId(),
                dto.getTagIds(),
                null
        );
    }
}
