package com.example.projectboard.service;

import com.example.projectboard.ArticleDto;
import com.example.projectboard.domain.type.SearchType;
import com.example.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;
    @Mock private ArticleRepository articleRepository;

    @Test
    @DisplayName("게시글을 검색 하면 게시글 리스트를 반환한다")
    void test1() {

        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그
        assertThat(articles).isNotNull();
    }

    @Test
    @DisplayName("게시글을 조회하면 반환한다")
    void test2() {

        ArticleDto articles = sut.searchArticle(1L);
        assertThat(articles).isNotNull();
    }

}