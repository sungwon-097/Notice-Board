package com.example.projectboard.domain;

import java.time.LocalDateTime;

public class Article {

    private Long id;
    private String title; // 제목
    private String content; // 본문
    private String hashtag; // 내용

    private LocalDateTime createAt; // 생성자
    private String createBy;
    private LocalDateTime modifiedAt; // 수정자
    private String modifiedBy;
}
