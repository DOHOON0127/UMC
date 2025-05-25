package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.service.StoreService;
import umc.study.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreService storeService;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null && storeService.existsById(value);
    }
} 