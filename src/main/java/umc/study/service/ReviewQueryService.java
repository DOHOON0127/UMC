package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public Page<Review> getMyReviews(Long memberId, Integer page) {
        return reviewRepository.findAllByMemberId(memberId, PageRequest.of(page - 1, 10));
    }
} 