package de.sni.demo.businesslogic.comment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CommentRepository
{
    Comment save(final Comment comment);

    void deleteById(final String commentId);

    Optional<Comment> findById(final String commentId);

    List<Comment> findAll();
}
