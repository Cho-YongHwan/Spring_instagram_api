package com.instagram.api.service;

import com.instagram.api.domain.entity.StoryEntity;
import com.instagram.api.domain.repository.StoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StoryService {

    private StoryRepository storyRepository;

    public List<StoryEntity> getStoryByUserIdEndTime(long userId) {
        List<StoryEntity> list = storyRepository.findByIdAndTimeEndGreaterThan(userId, LocalDateTime.now());
        return list;
    }

    public Optional<StoryEntity> getStoryByUserId(long userId) {
        Optional<StoryEntity> list = storyRepository.findById(userId);
        return list;
    }
}
