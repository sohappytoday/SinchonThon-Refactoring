package shinchonton.backend.answer.dummy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.repository.AnswerRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnswerDummy {

    private final AnswerRepository answerRepository;

    @PostConstruct
    public void initAnswers() {
        List<Answer> answers = List.of(
                // 1
                Answer.builder()
                        .answerContent("문과")
                        .build(),
                // 2
                Answer.builder()
                        .answerContent("이과")
                        .build(),
                // 3
                Answer.builder()
                        .answerContent("예체능")
                        .build(),
                // 4
                Answer.builder()
                        .prev1Id(1L)
                        .answerContent("국어")
                        .build(),
                // 5
                Answer.builder()
                        .prev1Id(1L)
                        .answerContent("외국어")
                        .build(),
                // 6
                Answer.builder()
                        .prev1Id(1L)
                        .answerContent("통합사회")
                        .build(),
                // 7
                Answer.builder()
                        .prev1Id(2L)
                        .answerContent("수학")
                        .build(),
                // 8
                Answer.builder()
                        .prev1Id(2L)
                        .answerContent("과학")
                        .build(),
                // 9
                Answer.builder()
                        .prev1Id(2L)
                        .answerContent("물리")
                        .build(),
                // 10
                Answer.builder()
                        .prev1Id(2L)
                        .answerContent("화학")
                        .build(),
                // 11
                Answer.builder()
                        .prev1Id(2L)
                        .answerContent("생물")
                        .build(),
                // 12
                Answer.builder()
                        .prev1Id(2L)
                        .answerContent("지구과학")
                        .build(),
                // 13
                Answer.builder()
                        .prev1Id(2L)
                        .answerContent("정보")
                        .build(),
                // 14
                Answer.builder()
                        .prev1Id(3L)
                        .answerContent("체육")
                        .build(),
                // 15
                Answer.builder()
                        .prev1Id(3L)
                        .answerContent("미술")
                        .build(),
                // 16
                Answer.builder()
                        .prev1Id(3L)
                        .answerContent("음악")
                        .build(),
                // 17
                Answer.builder()
                        .prev1Id(3L)
                        .answerContent("기타")
                        .build(),
                // 18
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .answerContent("중학생")
                        .build(),
                // 19
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .answerContent("고등학생")
                        .build(),
                // 20
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(18L)
                        .answerContent("단어를 잘게 나누어 어떤 뜻을 가지고 있는지 알아보는 게 재밌었어")
                        .build(),
                // 21
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(18L)
                        .answerContent("수업 시간에 내가 직접 짧은 소설이나 이야기를 쓰는 게 즐거웠어")
                        .build(),
                // 22
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(18L)
                        .answerContent("시나 소설을 읽고 인물의 성격이나 작품의 주제를 찾아내는 게 흥미로웠어")
                        .build(),
                // 23
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(18L)
                        .answerContent("친구들 앞에서 내가 읽은 책이나 시를 소개하고 설명하는 게 즐거웠어")
                        .build(),
                // 24
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(18L)
                        .answerContent("눈에 보이는 것을 직접 만들어 보는 게 재밌었어")
                        .build(),
                // 25
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(18L)
                        .answerContent("코드에서 오류를 찾아 해결하는 것이 재미있었어")
                        .build(),
                // 26
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(18L)
                        .answerContent("새로운 문법을 배우는 것이 재미있었어")
                        .build(),
                // 27
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(18L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),
                // 28
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(18L)
                        .answerContent("공식이 왜 그렇게 되는지 규칙을 알게 될 때 재밌었어")
                        .build(),
                // 29
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(18L)
                        .answerContent("어려운 문제를 혼자 끝까지 풀어냈을 때 재밌었어")
                        .build(),
                // 30
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(18L)
                        .answerContent("시험에서 어려운 문제 맞췄을 때 재밌었어")
                        .build(),
                // 31
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(18L)
                        .answerContent("확률처럼 실생활에서 쓰이는게 신기했어")
                        .build(),
                // 32
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(18L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),
                // 33
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("인체 배우는 게 제일 재밌었어")
                        .build(),
                // 34
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("생태계나 동식물 이야기를 배우는 게 재밌었어")
                        .build(),
                // 35
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("자기장이 제일 재밌었어")
                        .build(),
                // 36
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("중력 같은 거 배우는 게 제일 재밌었어")
                        .build(),
                // 37
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("화학 반응하는거 배우는게 제일 재밌었어")
                        .build(),
                // 38
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("원소에 대해 배우는게 제일 재밌었어")
                        .build(),
                // 39
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("날씨, 기후, 지질 현상을 관찰하고 배우는 게 재밌었어")
                        .build(),
                // 40
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("천체, 지구 구조, 자연재해 등을 배우는 게 재밌었어")
                        .build(),
                // 41
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("실험하는 게 제일 재밌었어")
                        .build(),
                // 42
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(8L)
                        .prev3Id(18L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),
                // 43
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(19L)
                        .answerContent("시나 소설 속 문장을 감상하고, 등장인물의 심리와 주제를 해석하는 게 흥미로웠어")
                        .build(),

// 44
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(19L)
                        .answerContent("고전 문학(예: 삼국유사, 조선시대 작품)과 현대 문학을 비교하면서 사회·문화적 차이를 이해하는 게 재밌었어")
                        .build(),

// 45
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(19L)
                        .answerContent("발표 시간에 작품 해석을 친구들에게 설명하고 토론하는 게 즐거웠어")
                        .build(),

// 46
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(19L)
                        .answerContent("글을 직접 쓰면서 내 생각을 표현하고, 다양한 글쓰기 방식(수필, 시, 논설 등)을 탐구하는 게 흥미로웠어")
                        .build(),

// 47
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(4L)
                        .prev3Id(19L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),

// 48
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("코딩하는게 재밌었어")
                        .build(),

// 49
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("프로그램을 직접 만들어 보는 게 재밌었어")
                        .build(),

// 50
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("컴퓨터 원리나 하드웨어 배우는 게 재밌었어")
                        .build(),

// 51
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("데이터 분석이나 자료 처리하는 게 재밌었어 - 컴퓨터공학, 데이터사이언스, 통계학, AI/빅데이터 학과")
                        .build(),

// 52
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("오류를 찾아 해결하는 게 재밌었어")
                        .build(),

// 53
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("AI 관련 내용이 재밌었어")
                        .build(),

// 54
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("컴퓨터 보안 쪽이 재미있었어")
                        .build(),

// 56
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(13L)
                        .prev3Id(19L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),
// 58
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(19L)
                        .answerContent("함수와 미적분이 재밌었어")
                        .build(),

// 59
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(19L)
                        .answerContent("경우의 수 같은 확률과 통계가 재밌었어")
                        .build(),

// 60
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(19L)
                        .answerContent("3차원 공간이나 내적을 다루는 기하와 벡터가 재밌었어")
                        .build(),

// 61
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(7L)
                        .prev3Id(19L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),

// 62
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(12L)
                        .prev3Id(19L)
                        .answerContent("날씨, 기후, 지질 현상을 배우는 게 재밌었어")
                        .build(),

// 63
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(12L)
                        .prev3Id(19L)
                        .answerContent("천체, 지구 구조, 자연재해 등을 배우는 게 재밌었어")
                        .build(),

// 64
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(12L)
                        .prev3Id(19L)
                        .answerContent("시대에 따른 다양한 생명체들을 배우는 게 재밌었어")
                        .build(),

// 65
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(12L)
                        .prev3Id(19L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),

// 66
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(11L)
                        .prev3Id(19L)
                        .answerContent("동식물, 생태, 환경을 배우는게 재밌었어")
                        .build(),

// 67
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(11L)
                        .prev3Id(19L)
                        .answerContent("인체에 대해서 배우는게 재밌었어")
                        .build(),

// 68
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(11L)
                        .prev3Id(19L)
                        .answerContent("야외 관찰/탐구하는게 재밌었어")
                        .build(),

// 69
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(11L)
                        .prev3Id(19L)
                        .answerContent("실험실에서 연구하는게 재밌었어")
                        .build(),

// 70
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(11L)
                        .prev3Id(19L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),

// 71
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(10L)
                        .prev3Id(19L)
                        .answerContent("실험으로 결과 관찰하는게 제일 재밌었어")
                        .build(),

// 72
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(10L)
                        .prev3Id(19L)
                        .answerContent("분자 구조/원리를 이해하는게 제일 재밌었어")
                        .build(),

// 73
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(10L)
                        .prev3Id(19L)
                        .answerContent("계산/수치 문제 푸는게 재미있었어")
                        .build(),

// 74
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(10L)
                        .prev3Id(19L)
                        .answerContent("원리 설명/모형화 문제 푸는게 재미있었어")
                        .build(),

// 75
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(10L)
                        .prev3Id(19L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build(),

// 76
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(9L)
                        .prev3Id(19L)
                        .answerContent("힘과 운동 파트가 재밌었어")
                        .build(),

// 77
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(9L)
                        .prev3Id(19L)
                        .answerContent("전기, 자기 파트가 재밌었어")
                        .build(),

// 78
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(9L)
                        .prev3Id(19L)
                        .answerContent("우주, 상대성이론 파트가 재밌었어")
                        .build(),

// 79
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(9L)
                        .prev3Id(19L)
                        .answerContent("파동, 광학 파트가 재밌었어")
                        .build(),

// 80
                Answer.builder()
                        .prev1Id(1L)
                        .prev2Id(9L)
                        .prev3Id(19L)
                        .answerContent("친구에게 내가 아는 내용을 설명해주는게 재밌었어")
                        .build()
        );


                answers.forEach(answer -> {
            if (answerRepository.findByAnswerContent(answer.getAnswerContent()).isEmpty()) {
                answerRepository.save(answer);
            }
        });
    }
}
