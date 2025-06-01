package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.Member;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toEntity(ReviewRequestDTO dto, Store store, Member member) {
        return Review.builder()
            .store(store)
            .member(member)
            .body(dto.getBody())
            .score(dto.getScore())
            .build();
    }

    public static Page<ReviewResponseDTO> toReviewResponseDTOPage(Page<Review> reviewPage) {
        return reviewPage.map(review -> ReviewResponseDTO.builder()
                .reviewId(review.getId())
                .content(review.getBody())
                .rating(review.getScore())
                .storeName(review.getStore().getName())
                .createdAt(review.getCreatedAt())
                .build());
    }
} 