package com.instagram.api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "likes")
@NoArgsConstructor
public class LikesEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int targetId;
    private int targetType;
    private int userId;

    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    public LikesEntity(Long id, int targetId, int targetType, int userId, LocalDateTime createdAt) {
        this.id = id;
        this.targetId = targetId;
        this.userId = userId;
        this.targetType = targetType;
        this.createdAt = createdAt;
    }
}
