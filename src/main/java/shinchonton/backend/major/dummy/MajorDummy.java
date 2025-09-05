package shinchonton.backend.major.dummy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shinchonton.backend.major.domain.Major;
import shinchonton.backend.major.repository.MajorRepository;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MajorDummy {

    private final MajorRepository majorRepository;

    @PostConstruct
    public void initMajors() {
        List<String> majors = Arrays.asList(
                "국어국문학과",
                "문예창작학과",
                "국어교육과",
                "컴퓨터공학과",
                "소프트웨어공학과",
                "교육학과",
                "컴퓨터교육학과",
                "수학과",
                "인공지능학과",
                "통계학과",
                "물리학과",
                "전자공학과",
                "기계공학과",
                "의예과",
                "약학과",
                "법학과",
                "경영학과",
                "경제학과",
                "산업공학과",
                "금융공학과",
                "생명공학과",
                "수학교육학과",
                "심리학과",
                "언론미디어학과",
                "인체생리학과",
                "간호학과",
                "보건학과",
                "생태학과",
                "환경학과",
                "산림학과",
                "수의학과",
                "농학과",
                "천문학과",
                "우주공학과",
                "재료공학과",
                "화학공학과",
                "화학과",
                "기상학과",
                "지리학과",
                "지질학과",
                "물리교육과",
                "화학교육과",
                "생물교육과",
                "지구과학교육과",
                "역사학과",
                "언론정보학과",
                "임베디드시스템학과",
                "데이터사이언스학과",
                "사이버정보보안학과",
                "응용수학과",
                "건축학과",
                "토목공학과",
                "항공우주공학과",
                "치의학과",
                "고분자생물학과",
                "식품공학과",
                "스포츠과학과",
                "전기전자공학과",
                "로봇공학과"
        );

        majors.stream()
                .distinct()
                .sorted()
                .forEach(name -> {
                    if (majorRepository.findByName(name).isEmpty()) {
                        majorRepository.save(Major.builder().name(name).build());
                    }
                });
    }
}