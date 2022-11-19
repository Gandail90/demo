package de.sni.demo.database.episode;

import de.sni.demo.database.theme.Theme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Node
@Getter
@AllArgsConstructor
public class Episode
{
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String episodeId;

    private String name;

    private URL link;

    @Relationship(type = "THEMES_OF", direction = Relationship.Direction.OUTGOING)
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
