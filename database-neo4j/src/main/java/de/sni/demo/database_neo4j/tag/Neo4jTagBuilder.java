package de.sni.demo.database_neo4j.tag;

import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.tag.TagBuilder;
import de.sni.demo.businesslogic.theme.Theme;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Neo4jTagBuilder implements TagBuilder
{
    @Override
    public Tag build(final String tagId, final String name, final List<Theme> themes)
    {
        return new Neo4jTag(
                tagId,
                name,
                themes);
    }
}
