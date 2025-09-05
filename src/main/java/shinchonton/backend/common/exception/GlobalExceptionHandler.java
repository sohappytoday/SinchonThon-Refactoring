package shinchonton.backend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shinchonton.backend.common.dto.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //data 반환 X
    private ResponseEntity<ApiResponse<?>> buildErrorResponse(HttpStatus status, String message) {
        ApiResponse<?> response = new ApiResponse<>(false, status.value(), message);
        return ResponseEntity.status(status).body(response);
    }

    //data 반환 필요 시
    private <T> ResponseEntity<ApiResponse<T>> buildErrorResponse(HttpStatus status, String message, T data) {
        ApiResponse<T> response = new ApiResponse<>(false, status.value(), message, data);
        return ResponseEntity.status(status).body(response);
    }
}
