package shinchonton.backend.favorite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shinchonton.backend.favorite.domain.Favorite;

@Getter
@AllArgsConstructor
@Builder
public class FavorResponse {
    private Long favoriteId;

    public static FavorResponse from(Favorite favorite){
        return FavorResponse.builder()
                .favoriteId(favorite.getId())
                .build();
    }
}
