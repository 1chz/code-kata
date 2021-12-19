package com.example.demo.adapter.persistence;

import com.example.demo.domain.Member;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String password;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Builder
    private MemberEntity(Long id, String email, String username, String password, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
    }

    public static MemberEntity convert(Member member) {
        return MemberEntity.builder()
            .email(member.getEmail())
            .username(member.getUsername())
            .password(member.getPassword())
            .build();
    }

    public Member toMember() {
        return Member.of(email, username, password, null);
    }

    public MemberEntity update(String username, String password) {
        this.username = username;
        this.password = password;
        return this;
    }

}
