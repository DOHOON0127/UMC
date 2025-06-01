package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long reviewId;
    private String content;
    private Float rating;
    private String storeName;
    private LocalDateTime createdAt;
} 