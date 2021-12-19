package com.example.demo.adapter.persistence;

import com.example.demo.domain.Member;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository jpaRepository;

    @Override
    @Transactional
    public Member save(Member member) {
        return jpaRepository.save(MemberEntity.convert(member))
            .toMember();
    }

    @Override
    @Transactional
    public Member update(String email, String username, String password) {
        return jpaRepository.findByEmail(email)
            .orElseThrow()
            .update(username, password)
            .toMember();
    }

}
