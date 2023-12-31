package de.sni.demo.businesslogic.episode;

import de.sni.demo.businesslogic.theme.Theme;

public interface Episode
{
    void rename(final String newName);
    void addTheme(final Theme theme);
}
