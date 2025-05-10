package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class FoodCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name;

//    음식 카테고리는 보통 수정/삭제를 잘 하지 않으므로 양방향 매핑X
//    @OneToMany(mappedBy = "food_category", cascade = CascadeType.ALL)
//    private List<MemberPrefer> memberPreferList = new ArrayList<>();
}