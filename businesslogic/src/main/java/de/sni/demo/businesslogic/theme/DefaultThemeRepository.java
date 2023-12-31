package de.sni.demo.businesslogic.theme;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultThemeRepository implements  ThemeRepository
{
    @Override
    public Theme save(final Theme theme)
    {
        throw new RuntimeException("DefaultThemeRepository should not be used");
    }

    @Override
    public void deleteById(final String themeId)
    {
        throw new RuntimeException("DefaultThemeRepository should not be used");
    }

    @Override
    public Optional<Theme> findById(final String themeId)
    {
        throw new RuntimeException("DefaultThemeRepository should not be used");
    }
}
