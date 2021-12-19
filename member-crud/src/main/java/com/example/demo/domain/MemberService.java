package com.example.demo.domain;

import java.time.LocalDate;

public interface MemberService {

    Member create(String email, String username, String password, LocalDate birthDay);

    Member update(String email, String username, String password, LocalDate birthDay);

}
