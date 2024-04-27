package de.sni.database_mongodb.episode;

import de.sni.demo.businesslogic.episode.Episode;
import de.sni.demo.businesslogic.theme.Theme;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Document(collection = "episode")
public class MongoDBEpisode extends AbstractAggregateRoot<MongoDBEpisode> implements Episode
{
    @Id
    private UUID episodeId;

    private String name;

    private URL link;

    @DocumentReference
    private List<Theme> themes;

    public void rename(final String newName)
    {
        this.name = newName;
    }

    public void addTheme(final Theme theme)
    {
        if (themes.isEmpty())
        {
            themes = new ArrayList<>();
        }

        themes.add(theme);
    }
}
