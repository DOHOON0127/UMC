package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionResponseDTO {
    private Long missionId;
    private String title;
    private String description;
    private Integer reward;
    private LocalDateTime deadline;
    private String status;
} 