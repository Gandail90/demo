package de.sni.demo.businesslogic.comment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultCommentRepository implements CommentRepository
{
    @Override
    public Comment save(final Comment comment)
    {
        throw new RuntimeException("DefaultCommentRepository should not be used");
    }

    @Override
    public void deleteById(final String commentId)
    {
        throw new RuntimeException("DefaultCommentRepository should not be used");
    }

    @Override
    public Optional<Comment> findById(final String commentId)
    {
        throw new RuntimeException("DefaultCommentRepository should not be used");
    }

    @Override
    public List<Comment> findAll()
    {
        throw new RuntimeException("DefaultCommentRepository should not be used");
    }
}
