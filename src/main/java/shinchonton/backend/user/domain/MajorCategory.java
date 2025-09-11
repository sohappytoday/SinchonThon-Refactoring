package shinchonton.backend.user.domain;

import java.util.Arrays;

public enum MajorCategory {
    LITERATURE,   // 문과
    SCIENCE,      // 이과
    ARTS;         //예체능

    public static MajorCategory from(String value) {
        return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidCategoryException());
    }// 예체능
}