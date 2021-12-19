package com.example.demo.domain;

import com.example.demo.adapter.persistence.MemberRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member create(String email, String username, String password, LocalDate birthDay) {
        return memberRepository.save(Member.of(
            email, username, password, birthDay)
        );
    }

    @Override
    public Member update(String email, String username, String password, LocalDate birthDay) {
        return memberRepository.update(email, username, password);
    }

}
