package io.github.shirohoo.ktcrud.member.adapter.out

import io.github.shirohoo.ktcrud.member.domain.Member
import io.github.shirohoo.ktcrud.member.port.out.RdbMemberCrudPort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class RdbMemberCrudAdapter(private val jpaRepository: MemberJpaRepository) : RdbMemberCrudPort {
    override fun save(member: Member): Member = jpaRepository.save(member)

    override fun findById(id: Long): Member = jpaRepository.findById(id).orElseThrow()

    override fun findAll(): List<Member> = jpaRepository.findAll()

    override fun update(member: Member): Member = jpaRepository.save(member)

    override fun deleteById(id: Long) = jpaRepository.deleteById(id)
}

interface MemberJpaRepository : JpaRepository<Member, Long> {}
