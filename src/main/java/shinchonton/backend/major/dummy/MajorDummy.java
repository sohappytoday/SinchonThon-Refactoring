package shinchonton.backend.major.dummy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.major.domain.Major;
import shinchonton.backend.major.repository.MajorRepository;
import shinchonton.backend.user.domain.Category;

import java.util.*;

@Component
@RequiredArgsConstructor
public class MajorDummy {

    private final MajorRepository majorRepository;

    // ✅ enum 매핑
    private static final Category C_HUM = Category.LITERATURE; // 문과
    private static final Category C_SCI = Category.SCIENCE;    // 이과
    private static final Category C_ART = Category.ARTS;       // 예체능

    @PostConstruct
    @Transactional
    public void initMajors() {

        // ---- 계열별 전공 분류 ----
        List<String> humanities = Arrays.asList(
                "국어국문학과","문예창작학과","국어교육과",
                "교육학과","법학과","경영학과","경제학과",
                "지리학과","언론미디어학과","언론정보학과"
        );

        List<String> science = Arrays.asList(
                "컴퓨터공학과","소프트웨어공학과","컴퓨터교육학과",
                "수학과","인공지능학과","통계학과","물리학과", "고분자생물학과",
                "전자공학과","기계공학과","전기전자공학과",
                "산업공학과","금융공학과","데이터사이언스학과",
                "사이버정보보안학과","응용수학과","화학과","화학공학과",
                "지질학과","기상학과","천문학과","지구과학교육과",
                "임베디드시스템학과","로봇공학과","재료공학과","우주공학과",
                "건축학과","토목공학과","식품공학과","생명공학과","생물교육과"
        );

        List<String> arts = Arrays.asList(
                "스포츠과학과"
        );

        List<String> medical = Arrays.asList("의예과","약학과","간호학과","치의학과");

        // 전체 전공 집합
        Set<String> allMajors = new TreeSet<>();
        allMajors.addAll(humanities);
        allMajors.addAll(science);
        allMajors.addAll(arts);
        allMajors.addAll(medical);

        // ---- 전공 소개 컨텐츠 ----
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("국어국문학과", "한국어와 문학 텍스트를 분석·해석하고 글쓰기 역량을 키우는 전공");
        contentMap.put("문예창작학과", "소설·시·에세이 등 창작 중심의 커리큘럼으로 스토리텔링 역량 강화");
        contentMap.put("국어교육과", "국어 교사 양성을 위한 교육학+국어학·문학 통합 전공");
        contentMap.put("컴퓨터공학과", "소프트웨어/하드웨어 전반, 알고리즘·시스템·네트워크를 다루는 전공");
        // ... (중략: 나머지는 기존 코드 그대로)
        String defaultContent = "전공 소개 준비 중";

        // ---- 저장 로직 ----
        for (String name : allMajors) {
            Category cat = resolveCategory(name, humanities, science, arts, medical);

            Major major = majorRepository.findByName(name).orElse(null);
            if (major == null) {
                major = Major.builder()
                        .name(name)
                        .content(contentMap.getOrDefault(name, defaultContent))
                        .category(cat) // ✅ category 지정
                        .build();
            } else {
                if (major.getContent() == null || major.getContent().isBlank()) {
                    major.setContent(contentMap.getOrDefault(name, defaultContent));
                }
                if (major.getCategory() == null) {
                    major.setCategory(cat);
                }
            }
            majorRepository.save(major);
        }
    }

    private Category resolveCategory(
            String name,
            List<String> humanities,
            List<String> science,
            List<String> arts,
            List<String> medical
    ) {
        if (humanities.contains(name)) return C_HUM;   // 문과 → LITERATURE
        if (science.contains(name))   return C_SCI;   // 이과
        if (arts.contains(name))      return C_ART;   // 예체능
        if (medical.contains(name))   return C_SCI;   // 의약은 보통 이과
        return C_SCI; // 기본값
    }
}
