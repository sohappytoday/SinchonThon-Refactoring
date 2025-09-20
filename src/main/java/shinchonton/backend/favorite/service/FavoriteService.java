package shinchonton.backend.favorite.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shinchonton.backend.favorite.domain.Favorite;
import shinchonton.backend.favorite.dto.FavorResponse;
import shinchonton.backend.favorite.repository.FavoriteRepository;
import shinchonton.backend.user.domain.User;
import shinchonton.backend.user.exception.UserNotFound;
import shinchonton.backend.user.repository.UserRepository;


@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;

    public FavorResponse favor(Long SenderId, Long ReceiverId){
        User Sender =  userRepository.findById(SenderId).orElseThrow(UserNotFound::new);
        User Receiver = userRepository.findById(ReceiverId).orElseThrow(UserNotFound::new);

        Favorite favorite = Favorite.create(Sender,Receiver);
        favoriteRepository.save(favorite);

        return FavorResponse.from(favorite);
    }

}
