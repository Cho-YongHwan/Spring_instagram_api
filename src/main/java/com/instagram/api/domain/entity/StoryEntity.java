package com.instagram.api.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "user_story")
@NoArgsConstructor
public class StoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Size(min = 4, max = 20)
    private int userId;

    private String imageUrl;
    private String caption;
    private String location;
    private String filter;
    private String linkUrl;

    @ColumnDefault("0") //default 0
    private int duration;

    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;

    @Builder
    public StoryEntity(Long id, int username, String imageUrl, String caption, String location, String filter, String linkUrl, int duration, LocalDateTime timeStart, LocalDateTime timeEnd) {
        this.id = id;
        this.userId = userId;
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
