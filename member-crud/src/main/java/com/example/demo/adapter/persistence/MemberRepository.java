package com.example.demo.adapter.persistence;

import com.example.demo.domain.Member;

public interface MemberRepository {

    Member save(Member member);

    Member update(String email, String username, String password);

}
