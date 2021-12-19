package com.example.demo.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberTest {

    Member member;

    @BeforeEach
    void setUp() {
        member = Member.of(
            "test@email.com",
            "username",
            "password",
            LocalDate.of(2_000, 12, 31)
        );
    }

    @Test
    void 회원가입() throws Exception {
        assertThat(member).isNotNull();
    }

    @Test
    void 회원정보수정() throws Exception {
        // ...given
        String updateUsername = "updateUsername";
        String updatePassword = "updatePassword";

        // ...when
        member = member.update(updateUsername, updatePassword);

        // ...then
        assertThat(member.getUsername()).isEqualTo(updateUsername);
        assertThat(member.getPassword()).isEqualTo(updatePassword);
    }

}
