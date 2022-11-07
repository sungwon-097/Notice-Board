package com.example.projectboard;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
        String title,
        String content,
        String hashtag,
        LocalDateTime createAt,
        String createBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) implements Serializable {
}
