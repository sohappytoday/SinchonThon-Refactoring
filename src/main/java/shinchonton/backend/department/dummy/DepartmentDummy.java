package shinchonton.backend.department.dummy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shinchonton.backend.department.domain.Department;
import shinchonton.backend.department.repository.DepartmentRepository;
import shinchonton.backend.user.domain.DepartmentCategory;

import java.util.List;

@Configuration
public class DepartmentDummy{

    @Bean
    CommandLineRunner initDepartments(DepartmentRepository departmentRepository) {
        return args -> {
            List<Department> departments = List.of(
                    Department.create("국어국문학과", "한국어와 문학을 연구하는 학과", DepartmentCategory.LITERATURE),
                    Department.create("영어영문학과", "영어와 영문학을 다루는 학과", DepartmentCategory.LITERATURE),
                    Department.create("사학과", "역사와 인류의 발자취를 연구하는 학과", DepartmentCategory.LITERATURE),
                    Department.create("수학과", "순수 및 응용 수학을 연구하는 학과", DepartmentCategory.SCIENCE),
                    Department.create("물리학과", "자연의 법칙을 탐구하는 학과", DepartmentCategory.SCIENCE),
                    Department.create("화학과", "물질의 성질과 반응을 연구하는 학과", DepartmentCategory.SCIENCE),
                    Department.create("생명과학과", "생명 현상을 연구하는 학과", DepartmentCategory.SCIENCE),
                    Department.create("미술학과", "순수미술 및 시각예술을 다루는 학과", DepartmentCategory.ARTS),
                    Department.create("체육학과", "신체 활동과 스포츠 과학을 연구하는 학과", DepartmentCategory.ARTS),
                    Department.create("음악학과", "음악 이론과 연주를 다루는 학과", DepartmentCategory.ARTS)
            );

            departmentRepository.saveAll(departments);
        };
    }
}
