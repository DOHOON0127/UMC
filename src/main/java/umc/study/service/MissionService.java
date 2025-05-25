package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.MissionRepository;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.converter.MissionConverter;
import umc.study.service.StoreService;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;
    private final StoreService storeService;
    public Mission addMission(MissionRequestDTO dto) {
        Store store = storeService.getById(dto.getStoreId());
        Mission mission = MissionConverter.toEntity(dto, store);
        return missionRepository.save(mission);
    }
} 