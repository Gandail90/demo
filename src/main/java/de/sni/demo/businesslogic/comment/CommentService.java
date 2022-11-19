package de.sni.demo.businesslogic.comment;

import de.sni.demo.database.comment.Comment;
import de.sni.demo.database.comment.CommentRepository;
import de.sni.demo.database.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment save(final Comment comment)
    {
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public void delete(final String commentId)
    {
        commentRepository.deleteById(commentId);
    }

    public Optional<Comment> getById(final String commentId)
    {
        return commentRepository.findById(commentId);
    }

    public List<Comment> getAll()
    {
        return commentRepository.findAll();
    }

    public Comment addLikeToComment(
            final Comment comment,
            final User user)
    {
        comment.addLike(user);

        return commentRepository.save(comment);
    }
}
