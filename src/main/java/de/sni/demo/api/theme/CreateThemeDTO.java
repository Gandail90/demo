package de.sni.demo.api.theme;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateThemeDTO
{
    private String themeId;

    private String text;

    private String timestamp;

    private List<String> tagIds;

    private String episodeId;
}
