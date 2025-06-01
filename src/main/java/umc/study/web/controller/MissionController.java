package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.converter.MissionConverter;
import umc.study.service.MissionQueryService;
import umc.study.validation.annotation.ValidPage;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/missions")
@Tag(name = "Mission", description = "미션 관련 API")
public class MissionController {
    private final MissionQueryService missionQueryService;

    @GetMapping("/store/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 페이지네이션하여 조회합니다.")
    public Page<MissionResponseDTO> getStoreMissions(
            @Parameter(description = "가게 ID") @PathVariable Long storeId,
            @Parameter(description = "페이지 번호 (1 이상)") @RequestParam @ValidPage Integer page) {
        return MissionConverter.toMissionResponseDTOPage(missionQueryService.getStoreMissions(storeId, page));
    }

    @GetMapping("/my")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "내가 진행중인 미션 목록을 페이지네이션하여 조회합니다.")
    public Page<MissionResponseDTO> getMyMissions(
            @Parameter(description = "회원 ID") @RequestParam Long memberId,
            @Parameter(description = "페이지 번호 (1 이상)") @RequestParam @ValidPage Integer page) {
        return MissionConverter.toMissionResponseDTOPage(missionQueryService.getMyMissions(memberId, page));
    }
} 