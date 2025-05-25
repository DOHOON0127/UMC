package umc.study.converter;

import umc.study.web.dto.MissionRequestDTO;
import umc.study.domain.Mission;
import umc.study.domain.Store;

public class MissionConverter {
    public static Mission toEntity(MissionRequestDTO dto, Store store) {
        return Mission.builder()
            .store(store)
            .missionSpec(dto.getMissionSpec())
            .reward(dto.getReward())
            .deadline(dto.getDeadline())
            .build();
    }
} 