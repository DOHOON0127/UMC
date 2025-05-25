package umc.study.web.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.apiPayload.ApiResponse;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}