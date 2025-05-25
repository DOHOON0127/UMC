package umc.study.converter;

import umc.study.web.dto.ReviewRequestDTO;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.Member;

public class ReviewConverter {
    public static Review toEntity(ReviewRequestDTO dto, Store store, Member member) {
        return Review.builder()
            .store(store)
            .member(member)
            .body(dto.getBody())
            .score(dto.getScore())
            .build();
    }
} 