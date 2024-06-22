package com.fitmate.workoutstudy_backend_alarm.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "users")
@DynamicInsert
public class Users extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String oauthId;
    private String oauthType;
    private String nickName;
    private String fcmToken;
    private Boolean state;

    public void setNickname(String nickname) {
        this.nickName = nickname;
    }

    public void setUserDelete() {
        this.state = true;
    }
}
