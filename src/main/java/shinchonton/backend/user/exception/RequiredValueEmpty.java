package shinchonton.backend.user.exception;

import org.hibernate.usertype.BaseUserTypeSupport;
import shinchonton.backend.common.exception.BusinessException;
import shinchonton.backend.common.exception.ErrorCode;

//입력 덜 하였을 시
public class RequiredValueEmpty extends BusinessException{
    public RequiredValueEmpty() {
        super(ErrorCode.REQUIRED_VALUE_EMPTY);
    }
}
