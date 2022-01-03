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

@Setter
@Getter
@Entity(name = "user_story")
@NoArgsConstructor
public class StoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    @Email
    @Size(min = 4, max = 20)
    private String username;

    private String imageUrl;
    private String caption;
    private String location;
    private String filter;
    private String linkUrl;
    private int duration;
    private Timestamp timeStart;
    private Timestamp timeEnd;

    @Builder
    public StoryEntity(Long id, String username, String imageUrl, String caption, String location, String filter, String linkUrl, int duration, Timestamp timeStart, Timestamp timeEnd) {
        this.id = id;
        this.username = username;
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.location = location;
        this.filter = filter;
        this.linkUrl = linkUrl;
        this.duration = duration;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
}
