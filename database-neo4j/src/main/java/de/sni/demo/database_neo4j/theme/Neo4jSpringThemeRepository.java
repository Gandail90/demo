package de.sni.demo.database_neo4j.theme;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Neo4jSpringThemeRepository extends Neo4jRepository<Neo4jTheme, String>
{
    public List<Neo4jTheme> findAllByTagIdsContains(final String tagId);

    public List<Neo4jTheme> findAllByTextContains(final String text);
}
