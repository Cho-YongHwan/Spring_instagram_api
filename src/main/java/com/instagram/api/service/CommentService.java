package com.instagram.api.service;

import com.instagram.api.domain.entity.CommentEntity;
import com.instagram.api.domain.repository.CommentRepository;
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
public class CommentService {

    private CommentRepository commentRepository;

    @Transactional
    public ResponseEntity<Map> getPagingPostComment(Pageable pageable, int postId) {
        Page<CommentEntity> list = commentRepository.findAllByPostId(pageable, postId);

        Map result = new HashMap<>();
        result.put("list", list);

        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Map> insertPostComment(CommentEntity vo) {
        CommentEntity comment = commentRepository.save(vo);
        Map result = new HashMap<>();
        result.put("result", comment.getId());
        return ResponseEntity.ok(result);
    }
}
