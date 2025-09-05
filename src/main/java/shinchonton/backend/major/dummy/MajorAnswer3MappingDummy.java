package shinchonton.backend.major.dummy;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.repository.AnswerRepository;
import shinchonton.backend.major.domain.Major;
import shinchonton.backend.major.repository.MajorRepository;

import java.util.*;

@Component
@RequiredArgsConstructor
@DependsOn({"answerDummy", "majorDummy"})
public class MajorAnswer3MappingDummy {

    private final MajorRepository majorRepository;
    private final AnswerRepository answerRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void mapMajorsToAnswers3() {

        // ===== 국어/문학 계열 =====
        bindIds("국어국문학과", 20L,21L,22L,23L, 43L,44L,45L,46L,47L);
        bindIds("문예창작학과", 21L,22L,46L);
        bindIds("국어교육과", 23L,47L);
        bindManyIds(new String[]{"언론정보학과","언론미디어학과"}, 45L,47L);
        bindIds("역사학과", 44L);

        // ===== 컴퓨터/소프트웨어 계열 =====
        bindManyIds(new String[]{"컴퓨터공학과","소프트웨어공학과"},
                24L,25L,26L, 48L,49L,50L,51L,52L,53L,54L);
        bindManyIds(new String[]{"컴퓨터교육학과","교육학과"}, 27L,56L);
        bindIds("사이버정보보안학과", 54L,52L);
        bindIds("임베디드시스템학과", 50L,49L,48L,77L);
        bindIds("데이터사이언스학과", 51L,59L);
        bindIds("인공지능학과", 51L,53L);

        // ===== 수학/통계 계열 =====
        bindManyIds(new String[]{"수학과","응용수학과"},
                28L,29L,30L,31L,32L, 58L,59L,60L,61L);
        bindIds("수학교육학과", 32L,58L,59L,60L,61L);
        bindIds("통계학과", 31L,59L,51L);

        // ===== 물리/전기/기계/우주/재료/로봇 =====
        bindIds("물리학과", 35L,36L,41L, 76L,77L,78L,79L,80L);
        bindManyIds(new String[]{"전자공학과","전기전자공학과"}, 77L,79L,50L);
        bindIds("기계공학과", 76L,73L);
        bindIds("항공우주공학과", 78L,76L,79L,73L);
        bindIds("재료공학과", 72L,71L,74L,73L); // 분자/실험/모형화/계산 연계
        bindIds("로봇공학과", 50L,76L);

        // ===== 화학/생명/의학 계열 =====
        bindIds("화학과", 37L,38L,71L,72L);
        bindIds("화학공학과", 71L,73L,74L);
        bindManyIds(new String[]{"의예과","간호학과","치의학과","인체생리학과"}, 67L,69L);
        bindIds("약학과", 71L,72L,37L);
        bindIds("생명공학과", 66L,67L,69L);
        bindIds("생물교육과", 66L,67L,70L);

        // ===== 지구과학/천문/지리 =====
        bindIds("기상학과", 39L,62L);
        bindIds("지질학과", 39L,62L);
        bindIds("천문학과", 40L,63L);
        bindIds("지구과학교육과", 62L,63L,65L);
        bindIds("지리학과", 62L);

        // ===== 경영/경제/산업/금융 =====
        bindIds("경영학과", 51L,59L);
        bindIds("경제학과", 59L,51L);
        bindIds("산업공학과", 51L,59L);
        bindIds("금융공학과", 59L,31L,51L);

        // ===== 예체능(체육/미술/음악) → answer3엔 직접 매칭할 문항이 없으니 스킵 =====
        // (answer3 단계에 체육/미술/음악 관련 선택지가 들어오면 여기 추가)
    }

    /* ========== 헬퍼들 ========== */

    private void bindIds(String majorName, Long... answerIds) {
        bindManyIds(new String[]{majorName}, answerIds);
    }

    private void bindManyIds(String[] majorNames, Long... answerIds) {
        if (answerIds == null || answerIds.length == 0) return;

        // 존재하는 것만 조회 (없는 ID는 자동 스킵)
        List<Long> ids = Arrays.stream(answerIds).distinct().toList();
        List<Answer> answers = answerRepository.findAllById(ids);
        if (answers.isEmpty()) return;

        for (String majorName : majorNames) {
            majorRepository.findByName(majorName).ifPresent(major -> {
                // answers3 Lazy 초기화
                Hibernate.initialize(major.getAnswers3());
                if (major.getAnswers3() == null) {
                    major.setAnswers3(new ArrayList<>());
                }
                // 중복 없이 추가
                Set<Long> have = new HashSet<>();
                major.getAnswers3().forEach(a -> have.add(a.getAnswerId()));
                for (Answer a : answers) {
                    if (!have.contains(a.getAnswerId())) {
                        major.getAnswers3().add(a);
                    }
                }
                majorRepository.save(major); // owning side가 Major 라고 가정
            });
        }
    }
}
