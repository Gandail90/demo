package de.sni.demo.businesslogic.tag;

import de.sni.demo.businesslogic.theme.Theme;

public interface Tag
{
    String getTagId();

    void addTheme(final Theme theme);

    void setName(final String name);
}
