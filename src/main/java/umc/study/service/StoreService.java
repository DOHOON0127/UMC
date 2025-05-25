package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.StoreRepository;
import umc.study.domain.Store;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    public boolean existsById(Long id) {
        return storeRepository.existsById(id);
    }
    public Store getById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("가게 없음"));
    }
} 