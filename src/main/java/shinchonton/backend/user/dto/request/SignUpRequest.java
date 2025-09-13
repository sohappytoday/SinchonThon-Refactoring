package shinchonton.backend.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shinchonton.backend.user.domain.DepartmentCategory;
import shinchonton.backend.user.domain.UserType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {
    private UserType userType;
    private String name;
    private String account;
    private String password;


    private MentorInfo mentor;
    private MenteeInfo mentee;

    @Getter
    public static class MentorInfo {
        private String nickname;
        private String schoolName;
        private DepartmentCategory departmentCategory; //문과/이과/예체능
        private String department;                //학과
        private String description;
        private String openChatUrl;
    }

    @Getter
    public static class MenteeInfo {
        private String nickname;
        private Long age;
    }
}


