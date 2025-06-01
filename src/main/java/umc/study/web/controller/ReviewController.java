package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.converter.ReviewConverter;
import umc.study.service.ReviewQueryService;
import umc.study.validation.annotation.ValidPage;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
@Tag(name = "Review", description = "리뷰 관련 API")
public class ReviewController {
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/my")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰 목록을 페이지네이션하여 조회합니다.")
    public Page<ReviewResponseDTO> getMyReviews(
            @Parameter(description = "회원 ID") @RequestParam Long memberId,
            @Parameter(description = "페이지 번호 (1 이상)") @RequestParam @ValidPage Integer page) {
        return ReviewConverter.toReviewResponseDTOPage(reviewQueryService.getMyReviews(memberId, page));
    }
} 