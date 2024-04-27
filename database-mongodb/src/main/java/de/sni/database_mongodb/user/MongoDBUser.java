package de.sni.database_mongodb.user;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.theme.Theme;
import de.sni.demo.businesslogic.user.User;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@AllArgsConstructor
@Document(collection = "user")
public class MongoDBUser extends AbstractAggregateRoot<MongoDBUser> implements User
{
    @Id
    private String userId;

    @Setter
    private String name;

    @Setter
    private String password;

    @DocumentReference
    private List<Theme> themesIds;

    private List<Comment> commentsIds;
}
