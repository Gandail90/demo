package de.sni.demo.database_neo4j.comment;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
@Profile("Neo4j")
@RequiredArgsConstructor
public class Neo4jCommentRepository implements CommentRepository
{
    private final Neo4jSpringCommentRepository repository;

    @Override
    public Comment save(final Comment comment)
    {
        return repository.save((Neo4jComment) comment);
    }

    @Override
    public void deleteById(final String commentId)
    {
        repository.deleteById(commentId);
    }

    @Override
    public Optional<Comment> findById(final String commentId)
    {
        return repository.findById(commentId)
                .map(Comment.class::cast);
    }

    @Override
    public List<Comment> findAll()
    {
        return repository.findAll().stream()
                .map(Comment.class::cast)
                .toList();
    }
}
