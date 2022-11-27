package com.example.projectboard;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
        String title,
        String content,
        String hashtag,
        LocalDateTime createAt,
        String createBy
) implements Serializable {
    public static ArticleDto of(String title, String content, String hashtag, LocalDateTime createAt, String createBy) {
        return new ArticleDto(title, content, hashtag, createAt, createBy);
    }
}
