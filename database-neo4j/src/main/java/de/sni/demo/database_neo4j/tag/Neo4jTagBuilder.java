package de.sni.demo.database_neo4j.tag;

import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.tag.TagBuilder;
import de.sni.demo.businesslogic.theme.Theme;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
@Profile("Neo4j")
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
