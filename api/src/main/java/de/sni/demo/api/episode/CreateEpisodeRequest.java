package de.sni.demo.api.episode;

import lombok.Data;

@Data
public class CreateEpisodeRequest
{
    private final String name;
    private final String link;
}
