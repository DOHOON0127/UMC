package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService;
import umc.study.service.MissionService;
import umc.study.service.MemberMissionService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.ChallengeRequestDTO;
import umc.study.domain.Review;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final ReviewService reviewService;
    private final MissionService missionService;
    private final MemberMissionService memberMissionService;

    // 2. 가게에 리뷰 추가
    @PostMapping("/reviews")
    public Review addReview(@RequestBody @Valid ReviewRequestDTO request) {
        return reviewService.addReview(request);
    }

    // 3. 가게에 미션 추가
    @PostMapping("/missions")
    public Mission addMission(@RequestBody @Valid MissionRequestDTO request) {
        return missionService.addMission(request);
    }

    // 4. 가게의 미션 도전
    @PostMapping("/missions/challenge")
    public MemberMission challengeMission(@RequestBody @Valid ChallengeRequestDTO request) {
        return memberMissionService.challengeMission(request);
    }
} 