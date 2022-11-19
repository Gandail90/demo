package de.sni.demo.api.comment;

import lombok.Data;

@Data
public class CreateCommentDTO
{
    private String text;

    private String creatorId;

    private String themeId;
}
