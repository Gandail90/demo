package de.sni.demo.api.comment;

import de.sni.demo.businesslogic.UserService;
import de.sni.demo.database.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class CommentDTOConverter
{
    private final UserService userService;

    public Comment convert(final CreateCommentDTO dto)
    {
        return new Comment(
                null,
                dto.getText(),
                null,
                userService.getById(dto.getCreatorId())
                        .orElse(null),
                dto.getThemeId(),
                new ArrayList<>());
    }
}
