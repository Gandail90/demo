package de.sni.demo.businesslogic.user;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.theme.Theme;

import java.util.List;

public interface User
{
    String getId();
    void setName(final String newName);

    List<Theme> getThemes();

    List<Comment> getComments();
}
