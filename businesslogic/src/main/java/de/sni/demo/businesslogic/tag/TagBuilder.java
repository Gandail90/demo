package de.sni.demo.businesslogic.tag;

import de.sni.demo.businesslogic.theme.Theme;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagBuilder
{
    Tag build(
            final String tagId,
            final String name,
            final List<Theme> themes);
}
