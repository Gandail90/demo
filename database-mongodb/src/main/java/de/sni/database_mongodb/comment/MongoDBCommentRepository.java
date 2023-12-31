package de.sni.database_mongodb.comment;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Primary
@Component
@Profile("MongoDB")
@RequiredArgsConstructor
public class MongoDBCommentRepository implements CommentRepository
{
    private final MongoDBSpringCommentRepository repository;

    @Override
    public Comment save(final Comment comment) {
        return repository.save((MongoDBComment) comment);
    }

    @Override
    public void deleteById(final String commentId)
    {

        if (commentId == null)
        {
            return;
        }
        repository.deleteById(UUID.fromString(commentId));
    }

    @Override
    public Optional<Comment> findById(final String commentId) {

        if (commentId == null)
        {
            return Optional.empty();
        }
        return repository.findById(UUID.fromString(commentId))
                .map(Comment.class::cast);
    }

    @Override
    public List<Comment> findAll() {
        return repository.findAll().stream()
                .map(Comment.class::cast)
                .collect(Collectors.toList());
    }
}
