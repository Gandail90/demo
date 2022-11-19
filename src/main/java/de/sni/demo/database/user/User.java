package de.sni.demo.database.user;

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
public class User
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
}
