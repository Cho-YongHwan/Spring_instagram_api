package com.instagram.api.service;

import com.instagram.api.domain.entity.LikesEntity;
import com.instagram.api.domain.repository.LikesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LikesService {

    private LikesRepository likesRepository;

    public LikesEntity didLikePost(LikesEntity vo) {
        LikesEntity likes = likesRepository.findByTargetIdAndTargetTypeAndUserId(vo.getTargetId(), 1, vo.getUserId());
        return likes;
    }

    public LikesEntity likePost(LikesEntity vo) {
        LikesEntity likes = likesRepository.save(vo);
        return likes;
    }

    public void unlikePost(LikesEntity vo) {
        likesRepository.delete(vo);
    }
//
//    public ResponseEntity<Map> likePost(LikesEntity vo) {
//        vo.setTargetType(1);
//        LikesEntity likes = likesRepository.save(vo);
//        Map result = new HashMap<>();
//        result.put("result", likes.getId());
//        return ResponseEntity.ok(result);
//    }
}
