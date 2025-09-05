package shinchonton.backend.major.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MajorResponse {
    private String name;
    private String content;
}