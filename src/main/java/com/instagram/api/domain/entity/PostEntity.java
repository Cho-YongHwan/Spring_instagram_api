package com.instagram.api.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity(name = "posts")
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int userId;
    private String textcontent;
    private boolean commentsAllowed;
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private List<MediaEntity> media;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private List<CommentEntity> comment;

    @Builder
    public PostEntity(Long id, int userId, String textcontent, LocalDateTime createdAt, UserEntity user, List<MediaEntity> media) {
        this.id = id;
        this.userId = userId;
        this.textcontent = textcontent;
        this.createdAt = createdAt;
        this.user = user;
        this.media = media;
    }
}
