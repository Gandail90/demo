package de.sni.database_mongodb.theme;

import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.theme.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Primary
@Component
@Profile("MongoDB")
@RequiredArgsConstructor
public class MongoDBThemeRepository implements ThemeRepository
{
    private final MongoDBSpringThemeRepository repository;

    @Override
    public Theme save(final Theme theme)
    {
        return repository.save((MongoDBTheme) theme);
    }

    @Override
    public void deleteById(final String themeId)
    {
        if (themeId == null)
        {
            return;
        }

        repository.deleteById(UUID.fromString(themeId));
    }

    @Override
    public Optional<Theme> findById(final String themeId)
    {
        if (themeId == null)
        {
            return Optional.empty();
        }

        return repository.findById(UUID.fromString(themeId))
                .map(Theme.class::cast);
    }
}
