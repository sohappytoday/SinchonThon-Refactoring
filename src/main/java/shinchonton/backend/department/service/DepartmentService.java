package shinchonton.backend.department.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shinchonton.backend.answer.domain.Answer;
import shinchonton.backend.answer.exception.InvalidAnswerId;
import shinchonton.backend.answer.repository.AnswerRepository;
import shinchonton.backend.department.domain.AnswerDepartment;
import shinchonton.backend.department.domain.Department;
import shinchonton.backend.department.dto.DepartmentResponse;
import shinchonton.backend.department.repository.AnswerDepartmentRepository;
import shinchonton.backend.department.repository.DepartmentRepository;
import shinchonton.backend.user.exception.DepartmentNotFound;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final AnswerRepository answerRepository;
    private final AnswerDepartmentRepository answerDepartmentRepository;
    private final DepartmentRepository departmentRepository;

    public List<DepartmentResponse> showDepartmentListByAnswerId(Long answerId) {
        //답변 찾고
        Answer answer = answerRepository.findById(answerId).orElseThrow(InvalidAnswerId::new);
        //연관되어 있는 테이블에서 department list를 찾고
        List<AnswerDepartment> answerDepartmentList = answerDepartmentRepository.findAllByAnswer(answer);

        //Response List 만들고
        List<DepartmentResponse> responseList = new ArrayList<>();
        //Department Id로 Response 만들고 List에 삽입
        for(AnswerDepartment answerDepartment : answerDepartmentList){
            Long DepartmentId = answerDepartment.getDepartment().getId();
            Department department = departmentRepository.findById(DepartmentId).orElseThrow(DepartmentNotFound::new);
            DepartmentResponse departmentResponse = DepartmentResponse.from(department);

            responseList.add(departmentResponse);
        }
        return responseList;
    }
}
