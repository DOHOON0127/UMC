package umc.study.converter;

import umc.study.web.dto.ChallengeRequestDTO;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus; // Assuming this is the correct import for MissionStatus

public class MemberMissionConverter {
    public static MemberMission toEntity(ChallengeRequestDTO dto, Member member, Mission mission) {
        return MemberMission.builder()
            .member(member)
            .mission(mission)
            .status(MissionStatus.CHALLENGING) // Corrected to use MissionStatus enum
            .build();
    }
} 