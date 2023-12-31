package de.sni.database_mongodb.tag;

import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.tag.TagBuilder;
import de.sni.demo.businesslogic.theme.Theme;

import java.util.List;
import java.util.UUID;

public class MongoDBTagBuilder implements TagBuilder
{
    @Override
    public Tag build(
            final String tagId,
            final String name,
            final List<Theme> themes)
    {

        return new MongoDBTag(
                tagId != null ? UUID.fromString(tagId) : null,
                name,
                themes);
    }
}
