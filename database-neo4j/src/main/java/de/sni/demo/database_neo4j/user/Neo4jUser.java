package de.sni.demo.database_neo4j.user;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;

@Node
@Getter
@AllArgsConstructor
public class Neo4jUser implements User
{
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String userId;

    @Setter
    private String name;

    @Setter
    private String password;

    private List<String> themesIds;

    private List<String> commentsIds;

    @Override
    public String getId()
    {
        return userId;
    }

    @Override
    public List<Theme> getThemes()
    {
        return null;
    }

    @Override
    public List<Comment> getComments()
    {
        return null;
    }
}
