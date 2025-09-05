package shinchonton.backend.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shinchonton.backend.users.domain.Users;
import shinchonton.backend.users.repository.UsersRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryService {

    private final UsersRepository userRepository;

    public Users findById(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }
}
