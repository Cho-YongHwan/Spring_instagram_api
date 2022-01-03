package com.instagram.api.controller;

import com.instagram.api.domain.entity.StoryEntity;
import com.instagram.api.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/story/{username}")
    public List<StoryEntity> getStoryByUsername(@PathVariable String username) {
        System.out.println("getStoryByUsername");
        return storyService.getStoryByUsername(username);
    }
}
