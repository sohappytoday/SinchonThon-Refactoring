package shinchonton.backend.major.dummy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shinchonton.backend.major.domain.Major;
import shinchonton.backend.major.repository.MajorRepository;
import shinchonton.backend.users.domain.Category;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MajorDummy {

    private final MajorRepository majorRepository;

    private static final Map<String, Category> majorCategoryMap = new HashMap<>();

    static {
        // 문과 (LITERATURE)
        majorCategoryMap.put("국어국문학과", Category.LITERATURE);
        majorCategoryMap.put("문예창작학과", Category.LITERATURE);
        majorCategoryMap.put("국어교육과", Category.LITERATURE);
        majorCategoryMap.put("교육학과", Category.LITERATURE);
        majorCategoryMap.put("법학과", Category.LITERATURE);
        majorCategoryMap.put("경영학과", Category.LITERATURE);
        majorCategoryMap.put("경제학과", Category.LITERATURE);
        majorCategoryMap.put("수학교육학과", Category.LITERATURE);
        majorCategoryMap.put("심리학과", Category.LITERATURE);
        majorCategoryMap.put("언론미디어학과", Category.LITERATURE);
        majorCategoryMap.put("역사학과", Category.LITERATURE);
        majorCategoryMap.put("언론정보학과", Category.LITERATURE);

        // 이과 (SCIENCE)
        majorCategoryMap.put("컴퓨터공학과", Category.SCIENCE);
        majorCategoryMap.put("소프트웨어공학과", Category.SCIENCE);
        majorCategoryMap.put("컴퓨터교육학과", Category.SCIENCE);
        majorCategoryMap.put("수학과", Category.SCIENCE);
        majorCategoryMap.put("인공지능학과", Category.SCIENCE);
        majorCategoryMap.put("통계학과", Category.SCIENCE);
        majorCategoryMap.put("물리학과", Category.SCIENCE);
        majorCategoryMap.put("전자공학과", Category.SCIENCE);
        majorCategoryMap.put("기계공학과", Category.SCIENCE);
        majorCategoryMap.put("의예과", Category.SCIENCE);
        majorCategoryMap.put("약학과", Category.SCIENCE);
        majorCategoryMap.put("산업공학과", Category.SCIENCE);
        majorCategoryMap.put("금융공학과", Category.SCIENCE);
        majorCategoryMap.put("생명공학과", Category.SCIENCE);
        majorCategoryMap.put("인체생리학과", Category.SCIENCE);
        majorCategoryMap.put("간호학과", Category.SCIENCE);
        majorCategoryMap.put("보건학과", Category.SCIENCE);
        majorCategoryMap.put("생태학과", Category.SCIENCE);
        majorCategoryMap.put("환경학과", Category.SCIENCE);
        majorCategoryMap.put("산림학과", Category.SCIENCE);
        majorCategoryMap.put("수의학과", Category.SCIENCE);
        majorCategoryMap.put("농학과", Category.SCIENCE);
        majorCategoryMap.put("천문학과", Category.SCIENCE);
        majorCategoryMap.put("우주공학과", Category.SCIENCE);
        majorCategoryMap.put("재료공학과", Category.SCIENCE);
        majorCategoryMap.put("화학공학과", Category.SCIENCE);
        majorCategoryMap.put("화학과", Category.SCIENCE);
        majorCategoryMap.put("기상학과", Category.SCIENCE);
        majorCategoryMap.put("지리학과", Category.SCIENCE);
        majorCategoryMap.put("지질학과", Category.SCIENCE);
        majorCategoryMap.put("물리교육과", Category.SCIENCE);
        majorCategoryMap.put("화학교육과", Category.SCIENCE);
        majorCategoryMap.put("생물교육과", Category.SCIENCE);
        majorCategoryMap.put("지구과학교육과", Category.SCIENCE);
        majorCategoryMap.put("임베디드시스템학과", Category.SCIENCE);
        majorCategoryMap.put("데이터사이언스학과", Category.SCIENCE);
        majorCategoryMap.put("사이버정보보안학과", Category.SCIENCE);
        majorCategoryMap.put("응용수학과", Category.SCIENCE);
        majorCategoryMap.put("건축학과", Category.SCIENCE);
        majorCategoryMap.put("토목공학과", Category.SCIENCE);
        majorCategoryMap.put("항공우주공학과", Category.SCIENCE);
        majorCategoryMap.put("치의학과", Category.SCIENCE);
        majorCategoryMap.put("고분자생물학과", Category.SCIENCE);
        majorCategoryMap.put("식품공학과", Category.SCIENCE);
        majorCategoryMap.put("스포츠과학과", Category.SCIENCE);
        majorCategoryMap.put("전기전자공학과", Category.SCIENCE);
        majorCategoryMap.put("로봇공학과", Category.SCIENCE);
    }

    @PostConstruct
    public void initMajors() {
        majorCategoryMap.keySet().stream()
                .sorted()
                .forEach(name -> {
                    if (majorRepository.findByName(name).isEmpty()) {
                        Category category = majorCategoryMap.get(name);
                        majorRepository.save(
                                Major.builder()
                                        .name(name)
                                        .category(category)
                                        .build()
                        );
                    }
                });
    }
}