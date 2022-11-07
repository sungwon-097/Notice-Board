package com.example.projectboard.repository;

import com.example.projectboard.config.JpaConfig;
import com.example.projectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("testdb")
@DisplayName("JPA 연결 CRUD 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("Select Test")
    @Test
    void givenWhenThen() {

        List<Article> articleList = articleRepository.findAll();

        assertThat(articleList)
                .isNotNull()
                .hasSize(0);
        // mockaroo 를 사용하여 data.sql 파일에 입력 후 확인 가능
    }

    @DisplayName("Insert Test")
    @Test
    void insertTest(){
        long previousCount = articleRepository.count();

        Article savedArticle = articleRepository.save(Article.of("new article", "new content", "spring"));

        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("Update Test")
    @Test
    void updateTest(){

        Article article = articleRepository.findById(1L).orElseThrow();
        String hashtag = "springboot";
        article.setHashtag(hashtag);

        Article savedArticle = articleRepository.saveAndFlush(article);

        assertThat(articleRepository.count()).hasFieldOrPropertyWithValue("hashtag", hashtag);
    }

    @DisplayName("Delete Test")
    @Test
    void deleteTest(){

        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentSize = article.getArticleComments().size();

        articleRepository.delete(article);
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentSize);
    }
}