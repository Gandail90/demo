package de.sni.demo.database.tag;


import de.sni.demo.database.theme.Theme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.ArrayList;
import java.util.List;

@Node
@Getter
@AllArgsConstructor
public class Tag
{
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String tagId;

    @Setter
    private String name;

    @Relationship(type = "MATCHING_THEMES", direction = Relationship.Direction.INCOMING)
    private List<Theme> themes;

    public void addTheme(final Theme theme)
    {
        if (themes == null)
        {
            themes = new ArrayList<>();
        }

        themes.add(theme);
    }
}
