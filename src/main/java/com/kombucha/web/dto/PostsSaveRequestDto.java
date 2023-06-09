package com.kombucha.web.dto;

import com.kombucha.domain.posts.Posts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    @NotBlank(message = "게시글 제목을 입력하세요.")
    @Size(min = 1, max = 500, message = "제목은 500자 이하로 입력하세요.")
    private String title;
    @NotBlank(message = "게시글 내용을 입력하세요.")
    private String content;
    private String author;

    @Builder
    private PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
