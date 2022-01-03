package com.instagram.api.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@Entity(name = "users")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    @Email
    @Size(min = 4, max = 20)
    private String username;
    @Size(min = 5, max = 20)
    private String name;
    @Size(min = 5, max = 255)
    private String email;
    @NotEmpty
    @Size(min = 10, max = 255)
    private String password;
    private String bio;
    private String profileImageUrl;
    private Timestamp createdAt;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<FollowEntity> follows;

    @Builder
    public UserEntity(Long id, String username, String name, String email, String password, String bio, String profileImageUrl, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profileImageUrl = profileImageUrl;
        this.createdAt = createdAt;
    }
}
