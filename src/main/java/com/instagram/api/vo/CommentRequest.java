package com.instagram.api.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequest {
    private int postId;
    private int userId;
    private String content;
}
