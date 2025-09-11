package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

//학과가 리스트에 없을 때
public class MajorNotFound extends BusinessException {
    public MajorNotFound() {
        super(ErrorCode.MAJOR_NOT_FOUND);
    }
}
