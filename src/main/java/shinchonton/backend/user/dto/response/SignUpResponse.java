package shinchonton.backend.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.user.domain.User;

@Getter
@AllArgsConstructor
@Builder
public class SignUpResponse {
    private long userId;

    public static SignUpResponse from(User user){
        return SignUpResponse.builder()
                .userId(user.getUserId())
                .build();
    }
}
