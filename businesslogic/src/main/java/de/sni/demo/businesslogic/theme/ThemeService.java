package de.sni.demo.businesslogic.theme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeRepository themeRepository;

    public Theme save(final Theme theme)
    {
        return themeRepository.save(theme);
    }

    public void delete(final String themeId)
    {
        themeRepository.deleteById(themeId);
    }

    public Optional<Theme> getById(final String themeId)
    {
        return themeRepository.findById(themeId);
    }
}
