package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.web.dto.ChallengeRequestDTO;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotation.NotDuplicateChallenge;

@Component
@RequiredArgsConstructor
public class NotDuplicateChallengeValidator implements ConstraintValidator<NotDuplicateChallenge, ChallengeRequestDTO> {
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public boolean isValid(ChallengeRequestDTO value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return !memberMissionRepository.existsByMemberIdAndMissionId(value.getMemberId(), value.getMissionId());
    }
} 