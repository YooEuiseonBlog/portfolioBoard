package com.esy.portfolioboard.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    @Test
    void test() {
        Post build = Post.builder()
                .likes(3)
                .id(3L)
                .views(2)
                .build();
        System.out.println(build);
    }
}