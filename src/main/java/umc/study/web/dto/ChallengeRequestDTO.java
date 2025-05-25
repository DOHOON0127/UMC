package umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import umc.study.validation.annotation.NotDuplicateChallenge;

@NotDuplicateChallenge
@Getter
@Setter
public class ChallengeRequestDTO {
    @NotNull
    private Long memberId;
    @NotNull
    private Long missionId;
} 