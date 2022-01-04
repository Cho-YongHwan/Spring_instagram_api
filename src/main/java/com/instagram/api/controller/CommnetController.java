package com.instagram.api.controller;

import com.instagram.api.domain.entity.CommentEntity;
import com.instagram.api.service.CommentService;
import com.instagram.api.vo.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api")
@RestController
public class CommnetController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/post/comment/{postId}")
    public ResponseEntity<Map> getPostCommentList(@PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @PathVariable int postId) {
        System.out.println("getPostList");
        return commentService.getPagingPostComment(pageable, postId);
    }

    @PostMapping("/post/comment")
    public ResponseEntity<Map> insertPostComment(@RequestBody CommentEntity vo) {
        System.out.println("insertPostComment");
        return commentService.insertPostComment(vo);
    }

}
