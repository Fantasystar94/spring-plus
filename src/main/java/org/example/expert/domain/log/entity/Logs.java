package org.example.expert.domain.log.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.entity.Timestamped;

@Entity
@Table(name="logs")
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Logs extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long requestUserId;
    private String email;
    private String nickname;
    public Logs (Long requestUserId, String email, String nickname) {
        this.requestUserId = requestUserId;
        this.email = email;
        this.nickname = nickname;
    }
}
