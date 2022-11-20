package com.example.projectboard.controller;

import com.example.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@Disabled("구현중") // ignoring test
@DisplayName("View Controller - 게시글")
@Import(SecurityConfig.class)
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
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index")) // 해당 경로에 view 가 존재하는지 확인
                .andExpect(model().attributeExists("articles")); // articles 라는 이름의 attribute 가 model 에 존재하는지 확인
    }

    @DisplayName("[view] [GET] 게시글 상세 페이지 - 정상 호출")
    @Test
    void name1() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments")); // articles 라는 이름의 attribute 가 model 에 존재하는지
    }

    @DisplayName("[view] [GET] 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    void name2() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/search"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @DisplayName("[view] [GET] 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    void name3() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/hashtag"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
}