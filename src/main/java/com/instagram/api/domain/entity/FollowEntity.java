package com.instagram.api.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "user_follow")
@NoArgsConstructor
public class FollowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userId")
    private Long userId;
    private Long followingId;

    @Builder
    public FollowEntity(Long id, Long userId, Long followingId) {
        this.id = id;
        this.userId = userId;
        this.followingId = followingId;
    }
}
