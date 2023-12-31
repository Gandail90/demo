package de.sni.database_mongodb.user;

import de.sni.database_mongodb.comment.MongoDBComment;
import de.sni.database_mongodb.theme.MongoDBTheme;
import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Document(collection = "user")
public class MongoDBUser extends AbstractAggregateRoot<MongoDBUser> implements User
{
    @Id
    private UUID userId;

    @Setter
    private String name;

    @Setter
    private String password;

    @DBRef
    private List<Theme> themesIds;

    private List<Comment> commentsIds;
}
