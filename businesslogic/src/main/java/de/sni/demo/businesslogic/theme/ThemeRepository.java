package de.sni.demo.businesslogic.theme;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ThemeRepository
{
    Theme save(final Theme theme);

    void deleteById(final String themeId);

    Optional<Theme> findById(final String themeId);
}
