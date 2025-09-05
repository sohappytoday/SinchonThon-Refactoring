package shinchonton.backend.major.dummy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.major.domain.Major;
import shinchonton.backend.major.repository.MajorRepository;

import java.util.*;

@Component
@RequiredArgsConstructor
public class MajorDummy {

    private final MajorRepository majorRepository;

    @PostConstruct
    @Transactional
    public void initMajors() {
        List<String> majors = Arrays.asList(
                "국어국문학과","문예창작학과","국어교육과",
                "컴퓨터공학과","소프트웨어공학과","교육학과","컴퓨터교육학과",
                "수학과","인공지능학과","통계학과",
                "물리학과","전자공학과","기계공학과",
                "의예과","약학과","간호학과","치의학과",
                "법학과","경영학과","경제학과",
                "산업공학과","금융공학과",
                "생명공학과","생물교육과",
                "언론미디어학과","언론정보학과",
                "데이터사이언스학과","사이버정보보안학과","응용수학과",
                "전기전자공학과",
                "화학과","화학공학과",
                "지리학과","지질학과","기상학과","천문학과","지구과학교육과",
                "임베디드시스템학과","로봇공학과","재료공학과","우주공학과","건축학과","토목공학과",
                "스포츠과학과","식품공학과","고분자생물학과"
        );

        // 전공 소개 컨텐츠
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("국어국문학과", "한국어와 문학 텍스트를 분석·해석하고 글쓰기 역량을 키우는 전공");
        contentMap.put("문예창작학과", "소설·시·에세이 등 창작 중심의 커리큘럼으로 스토리텔링 역량 강화");
        contentMap.put("국어교육과", "국어 교사 양성을 위한 교육학+국어학·문학 통합 전공");
        contentMap.put("컴퓨터공학과", "소프트웨어/하드웨어 전반, 알고리즘·시스템·네트워크를 다루는 전공");
        contentMap.put("소프트웨어공학과", "대규모 소프트웨어 설계/개발 프로세스, 품질·테스트·DevOps 중심");
        contentMap.put("컴퓨터교육학과", "컴퓨터·SW 교육 방법론과 교육과정 설계를 배우는 전공");
        contentMap.put("교육학과", "학습이론·교육과정·평가·교육심리를 다루는 교육 전반 전공");
        contentMap.put("수학과", "해석·대수·기하·확률통계 등 수학의 이론과 모델링을 탐구");
        contentMap.put("인공지능학과", "기계학습·딥러닝·데이터마이닝·AI응용 중심 전공");
        contentMap.put("통계학과", "확률·통계이론과 데이터 분석·실험설계를 다루는 전공");
        contentMap.put("물리학과", "역학·전자기·양자·열통계 등 자연의 법칙을 탐구");
        contentMap.put("전자공학과", "전자회로·신호처리·반도체·통신 등을 다루는 전공");
        contentMap.put("전기전자공학과", "전력·전자·통신·제어까지 포괄하는 전기/전자 융합 전공");
        contentMap.put("기계공학과", "열유체·고체역학·제어·설계·제조 등 기계 시스템 전반");
        contentMap.put("의예과", "의학 기초소양 및 기초과학, 의사 양성 트랙의 전 단계");
        contentMap.put("약학과", "의약품 개발·제조·임상약학·약물동태학을 배우는 전공");
        contentMap.put("간호학과", "임상 간호 역량과 보건·공중보건 지식을 갖춘 간호사 양성");
        contentMap.put("치의학과", "구강 보건·치과 임상 중심 의학 전공");
        contentMap.put("데이터사이언스학과", "데이터 수집·가공·분석과 시각화, ML 응용 중심");
        contentMap.put("사이버정보보안학과", "암호·취약점·네트워크·시스템 보안과 보안관리");
        contentMap.put("화학과", "무기/유기/분석/물리화학 및 실험 중심 전공");
        contentMap.put("화학공학과", "공정/반응/전달현상 기반의 화학 프로세스 설계·최적화");
        contentMap.put("생명공학과", "생명체 원리 응용, 바이오의약/유전공학/합성생물학");
        contentMap.put("생물교육과", "생물 교사 양성용, 생명과학+교육학 융합");
        contentMap.put("기상학과", "대기물리·기후변화·수치예보 등 대기과학");
        contentMap.put("지질학과", "지구의 구성·역사·지질과정 탐구");
        contentMap.put("천문학과", "별/행성/우주론 등 천체물리·관측 중심");
        contentMap.put("지구과학교육과", "지구과학 교사 양성, 대기/지질/천문 교육");
        contentMap.put("지리학과", "자연·인문 지리와 GIS·공간분석");
        // 나머지는 기본 문구
        String defaultContent = "전공 소개 준비 중";

        majors.stream()
                .distinct()
                .sorted()
                .forEach(name -> {
                    Major m = majorRepository.findByName(name)
                            .orElseGet(() -> majorRepository.save(
                                    Major.builder().name(name).content(contentMap.getOrDefault(name, defaultContent)).build()
                            ));
                    if (m.getContent() == null || m.getContent().isBlank()) {
                        m.setContent(contentMap.getOrDefault(name, defaultContent));
                        majorRepository.save(m);
                    }
                });
    }
}
