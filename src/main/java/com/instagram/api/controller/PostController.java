package com.instagram.api.controller;

import com.instagram.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<Map> getPostList(@PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        System.out.println("getPostList");
        return postService.getPagingPost(pageable);
    }

    @GetMapping("/posts/{userId}")
    public ResponseEntity<Map> getUserPostList(@PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @PathVariable int userId) {
        System.out.println("getPostList");
        return postService.getPagingUserPost(pageable, userId);
    }
}