package shinchonton.backend.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shinchonton.backend.user.domain.UserType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {

    private UserType userType;  // MENTI, MENTO 구분
    private String name;
    private String account;     // 아이디 (이메일)
    private String password;    // 비밀번호
    private String nickname;    // 닉네임

    // Menti 전용
    private Long age;

    // Mento 전용
    private String schoolName;
    private String majorCategory;
    private String major;     // 과
    private String openChatUrl;
    private String description;
}

