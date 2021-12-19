package com.example.demo.domain;

import java.time.LocalDate;
import lombok.Value;

@Value(staticConstructor = "of")
public class Member {

    String email;

    String username;

    String password;

    LocalDate birthDay;

    public Member update(String username, String password) {
        return new Member(this.email, username, password, this.birthDay);
    }

}
