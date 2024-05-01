package de.sni.demo.api.user;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;

import java.util.List;

public class TestUser implements User
{
    private final String id;
    private String name;
    private final List<Theme> themes;
    private final List<Comment> comments;

    public TestUser(
            final String id,
            final String name,
            final List<Theme> themes,
            final List<Comment> comments)
    {
        this.id = id;
        this.name = name;
        this.themes = themes;
        this.comments = comments;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public void setName(final String newName)
    {
        this.name = newName;
    }

    @Override
    public List<Theme> getThemes()
    {
        return themes;
    }

    @Override
    public List<Comment> getComments()
    {
        return comments;
    }

    public String getName()
    {
        return name;
    }
}
