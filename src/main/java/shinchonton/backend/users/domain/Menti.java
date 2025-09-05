package shinchonton.backend.users.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.users.domain.Users;

@Entity
@DiscriminatorValue("MENTI") // dtype = 'MENTI'
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Menti extends Users {

    @Column
    private Long age;

    @Override
    public  UserType getUserType() {
        return UserType.MENTI;
    }

    @Builder
    public Menti(String account, String password, String nickname, Long age) {
        super(null, account, password, nickname);
        if (age == null){
            throw new IllegalArgumentException("age 없음");
        }
        this.age = age;
    }


}