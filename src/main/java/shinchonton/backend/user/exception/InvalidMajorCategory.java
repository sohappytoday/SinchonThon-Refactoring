package shinchonton.backend.user.exception;

import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

public class InvalidMajorCategory extends BusinessException {
    public InvalidMajorCategory() {
        super(ErrorCode.INVALID_MAJOR_CATEGORY);
    }
}
