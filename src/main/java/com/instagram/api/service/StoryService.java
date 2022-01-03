package com.instagram.api.service;

import com.instagram.api.domain.entity.StoryEntity;
import com.instagram.api.domain.repository.StoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StoryService {

    private StoryRepository storyRepository;

    public List<StoryEntity> getStoryByUsername(String username) {
        List<StoryEntity> list = storyRepository.findByUsername(username);
        return list;
    }
}
