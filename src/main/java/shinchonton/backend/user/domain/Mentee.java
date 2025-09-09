package shinchonton.backend.user.domain;

import jakarta.persistence.*;
import lombok.*;
import shinchonton.backend.user.domain.User;

@Entity
@DiscriminatorValue("MENTI") // dtype = 'MENTI'
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mentee extends User {

    @Column
    private Long age;

    @Override
    public  UserType getUserType() {
        return UserType.MENTI;
    }

    @Builder
    public Mentee(String account, String password, String nickname, Long age) {
        super(null, account, password, nickname);
        if (age == null){
            throw new IllegalArgumentException("age 없음");
        }
        this.age = age;
    }


}