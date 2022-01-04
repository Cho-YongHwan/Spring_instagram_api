package com.instagram.api.controller;

import com.instagram.api.domain.entity.LikesEntity;
import com.instagram.api.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/post/didLikePost")
    public LikesEntity didLikePost(@RequestBody LikesEntity vo) {
        System.out.println("didLikePost");
        return likesService.didLikePost(vo);
    }

    @PostMapping("/post/likePost")
    public LikesEntity likePost(@RequestBody LikesEntity vo) {
        System.out.println("likePost");
        return likesService.likePost(vo);
    }

    @PostMapping("/post/unlikePost")
    public ResponseEntity<Map> unlikePost(@RequestBody LikesEntity vo) {
        System.out.println("unlikePost");
        likesService.unlikePost(vo);
        return ResponseEntity.ok().body(new HashMap(200));
    }

}
