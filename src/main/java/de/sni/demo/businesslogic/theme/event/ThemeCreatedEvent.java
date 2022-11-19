package de.sni.demo.businesslogic.theme.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ThemeCreatedEvent
{
    private final String themeId;
    private final String episodeId;
    private final List<String> tagIds;
}
