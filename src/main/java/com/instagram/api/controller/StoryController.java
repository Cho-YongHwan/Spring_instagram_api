package com.instagram.api.controller;

import com.instagram.api.domain.entity.StoryEntity;
import com.instagram.api.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/story/endTime/{userId}")
    public List<StoryEntity> getStoryByUserIdEndTime(@PathVariable long userId) {
        System.out.println("getStoryByUserIdEndTime");
        return storyService.getStoryByUserIdEndTime(userId);

    }

    @GetMapping("/story/{userId}")
    public Optional<StoryEntity> getStoryByUserId(@PathVariable long userId) {
        System.out.println("getStoryByUserId");
        return storyService.getStoryByUserId(userId);
    }
}
