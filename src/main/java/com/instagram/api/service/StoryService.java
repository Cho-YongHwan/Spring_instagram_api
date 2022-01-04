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
        LocalDateTime nowDatetime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        List<StoryEntity> list = storyRepository.findByIdAndTimeEndGreaterThan(userId, nowDatetime);
        return list;
    }

    public Optional<StoryEntity> getStoryByUserId(long userId) {
        Optional<StoryEntity> list = storyRepository.findById(userId);
        return list;
    }
}
