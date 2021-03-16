package com.wy.community.controller;

import com.wy.community.model.dto.Result;
import com.wy.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/search/{page}/{size}")
    public Result getPostList(@RequestBody String params,
                              @PathVariable("page") Integer page,
                              @PathVariable("size") Integer size) {
        return null;

    }

}
