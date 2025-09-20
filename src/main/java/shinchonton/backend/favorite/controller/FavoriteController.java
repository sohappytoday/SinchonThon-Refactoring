package shinchonton.backend.favorite.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinchonton.backend.common.dto.response.ApiResponse;
import shinchonton.backend.favorite.domain.Favorite;
import shinchonton.backend.favorite.dto.FavorResponse;
import shinchonton.backend.favorite.service.FavoriteService;
import shinchonton.backend.token.jwt.TokenAuthenticationFilter;

@RestController
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoriteController {

    FavoriteService favoriteService;

    @PostMapping("/{mentorId}")
    public ResponseEntity<ApiResponse<FavorResponse>> Favor(@PathVariable Long mentorId,
                                                            @RequestAttribute(name = TokenAuthenticationFilter.ATTR_USER_ID)Long userId){

        FavorResponse favorResponse = favoriteService.favor(userId, mentorId);

        return ResponseEntity.ok(ApiResponse.success("찜하기에 성공하였습니다.",favorResponse));
    }
}
