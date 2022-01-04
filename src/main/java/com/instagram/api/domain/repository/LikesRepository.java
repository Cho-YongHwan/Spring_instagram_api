package com.instagram.api.domain.repository;

import com.instagram.api.domain.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<LikesEntity, Long> {
    LikesEntity findByTargetIdAndTargetTypeAndUserId(int targetId, int targetType, int userId);
}
