package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionResponseDTO;

public class MissionConverter {
    public static Mission toEntity(MissionRequestDTO dto, Store store) {
        return Mission.builder()
            .store(store)
            .missionSpec(dto.getMissionSpec())
            .reward(dto.getReward())
            .deadline(dto.getDeadline())
            .build();
    }

    public static Page<MissionResponseDTO> toMissionResponseDTOPage(Page<Mission> missionPage) {
        return missionPage.map(mission -> MissionResponseDTO.builder()
                .missionId(mission.getId())
                .title(mission.getMissionSpec())
                .description(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .status("IN_PROGRESS")
                .build());
    }
} 