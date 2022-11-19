package de.sni.demo.api.graphql;

import de.sni.demo.api.comment.CommentDTOConverter;
import de.sni.demo.api.comment.CreateCommentDTO;
import de.sni.demo.businesslogic.UserService;
import de.sni.demo.businesslogic.comment.CommentService;
import de.sni.demo.database.comment.Comment;
import de.sni.demo.database.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GraphQLCommentController
{
    private final CommentService service;
    private final CommentDTOConverter converter;

    private final UserService userService;

    @QueryMapping
    public Comment getCommentById(@Argument final String commentId)
    {
        return service.getById(commentId)
                .orElse(null);
    }

    @QueryMapping
    public List<Comment> getAllComments()
    {
        return service.getAll();
    }

    @MutationMapping
    public Comment createComment(@Argument CreateCommentDTO dto)
    {
        return service.save(converter.convert(dto));
    }

    @MutationMapping
    public Boolean likeComment(@Argument final String commentId,
                               @Argument final String userId)
    {
        final Optional<Comment> comment =
                service.getById(commentId);
        final Optional<User> user =
                userService.getById(userId);

        if (comment.isEmpty())
        {
            throw new RuntimeException(
                    String.format("Comment with id %s not found", commentId));
        }
        if (user.isEmpty())
        {
            throw new RuntimeException(
                    String.format("Comment with id %s not found", userId));
        }

        service.addLikeToComment(comment.get(), user.get());

        return true;
    }

    @MutationMapping
    public Boolean deleteComment(@Argument final String commentId)
    {
        try{
            service.delete(commentId);
            return true;
        } catch (final Exception exception)
        {
            return false;
        }
    }
}
