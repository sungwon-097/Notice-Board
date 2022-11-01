package com.example.projectboard.domain;

import java.time.LocalDateTime;

public class ArticleComment {

    private Long id;
    private Article article; // 게시글(ID)
    private String content; // 본문

    private LocalDateTime createAt; // 생성
    private String createBy;
    private LocalDateTime modifiedAt; // 수정
    private String modifiedBy;
}
