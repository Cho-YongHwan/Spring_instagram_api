package com.instagram.api.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@ToString(exclude = "post_media")
@Entity(name = "medias")
@NoArgsConstructor
public class MediaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postId")
    private int postId;
    private String contentType;
    private String contentUrl;

    @Builder
    public MediaEntity(Long id, int postId, String contentType, String contentUrl) {
        this.id = id;
        this.postId = postId;
        this.contentType = contentType;
        this.contentUrl = contentUrl;
    }
}
