package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryService {
    private final MissionRepository missionRepository;

    public Page<Mission> getStoreMissions(Long storeId, Integer page) {
        return missionRepository.findAllByStoreId(storeId, PageRequest.of(page - 1, 10));
    }

    public Page<Mission> getMyMissions(Long memberId, Integer page) {
        return missionRepository.findAllByMemberMissionList_MemberId(memberId, PageRequest.of(page - 1, 10));
    }
} 