package de.sni.demo.database_neo4j.theme;

import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.theme.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Primary
@Component
@Profile("Neo4j")
@RequiredArgsConstructor
public class Neo4jThemeRepository implements ThemeRepository
{
    private final Neo4jSpringThemeRepository repository;

    @Override
    public Theme save(final Theme theme)
    {
        return repository.save((Neo4jTheme) theme);
    }

    @Override
    public void deleteById(final String themeId)
    {
        repository.deleteById(themeId);
    }

    @Override
    public Optional<Theme> findById(final String themeId)
    {
        return repository.findById(themeId).map(Theme.class::cast);
    }
}
