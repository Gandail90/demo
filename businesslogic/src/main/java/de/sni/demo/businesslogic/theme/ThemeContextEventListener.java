package de.sni.demo.businesslogic.theme;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.CommentService;
import de.sni.demo.businesslogic.comment.event.CommentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ThemeContextEventListener
{
    private final ThemeService themeService;
    private final CommentService commentService;

    @EventListener
    public void handleCommentCreatedEvent(final CommentCreatedEvent event)
    {
        final Optional<Theme> theme = themeService.getById(event.getThemeId());
        final Optional<Comment> comment = commentService.getById(event.getCommentId());

        if (theme.isEmpty() || comment.isEmpty())
        {
            return;
        }

        theme.ifPresent(theme1 -> theme1.addComment(comment.get()));

        themeService.save(theme.get());
    }
}
