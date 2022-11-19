package de.sni.demo.businesslogic.comment.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentCreatedEvent
{
    private final String commentId;
    private final String themeId;
}
