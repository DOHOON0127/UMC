package umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.ExistStore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class ReviewRequestDTO {
    @ExistStore
    @NotNull
    private Long storeId;
    @NotNull
    private Long memberId;
    @NotBlank
    private String body;
    private Float score;
} 