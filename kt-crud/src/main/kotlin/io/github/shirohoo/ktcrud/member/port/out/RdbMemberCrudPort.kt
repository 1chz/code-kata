package io.github.shirohoo.ktcrud.member.port.out

import io.github.shirohoo.ktcrud.member.domain.Member

interface RdbMemberCrudPort {
    fun save(member: Member): Member

    fun findById(id: Long): Member

    fun findAll(): List<Member>

    fun update(member: Member): Member

    fun deleteById(id: Long)
}
