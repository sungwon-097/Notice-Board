package com.example.projectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View Controller - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
    private final MockMvc mvc;

    ArticleControllerTest(@Autowired MockMvc mvc) { // test 파일에서는 @Autowired 어노테이션이 필요하다
        this.mvc = mvc;
    }

    @DisplayName("[view] [GET] 게시글 리스트 페이지 - 정상 호출")
    @Test
    void name() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles")); // articles 라는 이름의 attribute 가 model 에 존재하는지

    }

    @DisplayName("[view] [GET] 게시글 상세 페이지 - 정상 호출")
    @Test
    void name1() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles")); // articles 라는 이름의 attribute 가 model 에 존재하는지
    }

    @DisplayName("[view] [GET] 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    void name2() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

    @DisplayName("[view] [GET] 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    void name3() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
}