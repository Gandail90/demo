package de.sni.database_mongodb.tag;

import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.theme.Theme;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Document(collection = "tag")
public class MongoDBTag implements Tag
{
    @Id
    private UUID tagId;

    @Setter
    private String name;

    @DBRef
    private List<Theme> themes;

    @Override
    public String getTagId()
    {
        return tagId.toString();
    }

    public void addTheme(final Theme theme)
    {
        if (themes == null)
        {
            themes = new ArrayList<>();
        }

        themes.add(theme);
    }
}
