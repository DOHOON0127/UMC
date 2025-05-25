package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.repository.MemberRepository;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.Member;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.converter.ReviewConverter;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreService storeService;
    private final MemberRepository memberRepository;
    public Review addReview(ReviewRequestDTO dto) {
        Store store = storeService.getById(dto.getStoreId());
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(() -> new RuntimeException("멤버 없음"));
        Review review = ReviewConverter.toEntity(dto, store, member);
        return reviewRepository.save(review);
    }
} 