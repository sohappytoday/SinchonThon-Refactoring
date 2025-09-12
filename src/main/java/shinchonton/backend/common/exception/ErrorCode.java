package shinchonton.backend.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    REDUNDANT_ACCOUNT("409", 409, "이미 존재하는 계정입니다."),
    USER_NOT_FOUND("404", 404, "존재하지 않는 사용자입니다."),
    INVALID_PASSWORD("401", 401, "비밀번호 오류입니다."),
    REQUIRED_VALUE_EMPTY("400",400, "입력하지 않은 사항이 있습니다."),
    MAJOR_NOT_FOUND("404",404, "리스트에 존재하지 않는 과입니다."),
    INVALID_MAJOR_CATEGORY("404",404,"학과 카테고리가 존재하지 않습니다."),
    INVALID_USER_TYPE("404",404, "유저 타입이 정확하지 않습니다."),
    DO_NOT_HAVE_PERMISSION("403",403, "권한이 없습니다.");

    private final String code;
    private final int status;
    private final String message;

}

