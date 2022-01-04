package com.instagram.api.domain.repository;

import com.instagram.api.domain.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

    Optional<StoryEntity> findById(long userId);

    List<StoryEntity> findByIdAndTimeEndGreaterThan(long userId, LocalDateTime nowDatetime);
}
