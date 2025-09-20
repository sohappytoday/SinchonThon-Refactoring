package shinchonton.backend.favorite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shinchonton.backend.favorite.domain.Favorite;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
}
