package de.sni.demo.database.theme;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends Neo4jRepository<Theme, String>
{

    public List<Theme> findAllByTagIdsContains(final String tagId);

    public List<Theme> findAllByTextContains(final String text);
}
