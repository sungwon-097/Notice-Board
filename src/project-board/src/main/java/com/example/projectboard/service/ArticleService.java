package com.example.projectboard.service;

import com.example.projectboard.ArticleDto;
import com.example.projectboard.domain.type.SearchType;
import com.example.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String searchType){
        return Page.empty();
    }
    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l){
        return null;
    }
}
