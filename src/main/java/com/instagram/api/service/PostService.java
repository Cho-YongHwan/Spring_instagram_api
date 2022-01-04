package com.instagram.api.service;

import com.instagram.api.domain.entity.PostEntity;
import com.instagram.api.domain.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    @Transactional
    public ResponseEntity<Map> getPagingPost(Pageable pageable) {
        Page<PostEntity> list = postRepository.findAll(pageable);
        Map result = new HashMap<>();
        result.put("list", list);

        return ResponseEntity.ok(result);
    }

    @Transactional
    public ResponseEntity<Map> getPagingUserPost(Pageable pageable, int userId) {
        Page<PostEntity> list = postRepository.findAllByUserId(pageable, userId);

        Map result = new HashMap<>();
        result.put("list", list);

        return ResponseEntity.ok(result);
    }
}
