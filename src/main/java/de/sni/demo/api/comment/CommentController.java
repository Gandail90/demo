package de.sni.demo.api.comment;

import de.sni.demo.businesslogic.comment.CommentService;
import de.sni.demo.businesslogic.UserService;
import de.sni.demo.database.comment.Comment;
import de.sni.demo.database.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "comment")
@RequiredArgsConstructor
public class CommentController
{
    private final CommentService commentService;
    private final CommentDTOConverter converter;

    private final UserService userService;

    @GetMapping(path = "{commentId}")
    public ResponseEntity<Comment> getById(
            @PathVariable("commentId") final String commentId)
    {
        return ResponseEntity.of(commentService.getById(commentId));
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Comment>> getAll()
    {
        return ResponseEntity.ok(
                commentService.getAll());
    }

    @PostMapping
    public ResponseEntity<Comment> create(
            @RequestBody final CreateCommentDTO dto)
    {
        return ResponseEntity.ok(commentService
                .save(converter.convert(dto)));
    }

    @PostMapping(path = "like")
    public ResponseEntity<Comment> like(
            @RequestBody final LikesCommentDTO dto)
    {
        final Optional<Comment> comment =
                commentService.getById(dto.getCommentId());
        final Optional<User> user = userService.getById(dto.getUserId());

        if (comment.isEmpty() || user.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                commentService.addLikeToComment(comment.get(), user.get()));
    }

    @DeleteMapping(path = "{commentId}")
    public ResponseEntity<Object> delete(
            @PathVariable("commentId") final String commentId)
    {
        try
        {
            commentService.delete(commentId);
            return ResponseEntity.ok().build();
        } catch (final Exception exception)
        {
            exception.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
