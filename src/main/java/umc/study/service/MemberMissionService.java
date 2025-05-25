package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.web.dto.ChallengeRequestDTO;
import umc.study.converter.MemberMissionConverter;

@Service
@RequiredArgsConstructor
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    public MemberMission challengeMission(ChallengeRequestDTO dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(() -> new RuntimeException("멤버 없음"));
        Mission mission = missionRepository.findById(dto.getMissionId()).orElseThrow(() -> new RuntimeException("미션 없음"));
        MemberMission memberMission = MemberMissionConverter.toEntity(dto, member, mission);
        return memberMissionRepository.save(memberMission);
    }
} 