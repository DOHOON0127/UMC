package umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class MissionRequestDTO {
    @NotNull
    private Long storeId;
    @NotBlank
    private String missionSpec;
    @NotNull
    private Integer reward;
    @NotNull
    private LocalDateTime deadline;
} 