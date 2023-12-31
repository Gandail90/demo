package de.sni.demo.api.comment;

import de.sni.demo.businesslogic.comment.Comment;
import de.sni.demo.businesslogic.comment.CommentBuilder;
import de.sni.demo.businesslogic.theme.ThemeService;
import de.sni.demo.businesslogic.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class CommentDTOConverter
{
    private final CommentBuilder commentBuilder;
    private final UserService userService;
    private final ThemeService themeService;

    public Comment convert(final CreateCommentDTO dto)
    {
        return commentBuilder
                .build(
                        null,
                        dto.getText(),
                        null,
                        userService.getById(dto.getCreatorId())
                                .orElse(null),
                        themeService.getById(dto.getThemeId())
                                .orElse(null),
                        new ArrayList<>());
    }
}
