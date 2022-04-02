package io.github.shirohoo.ktcrud.member.adapter.`in`

import io.github.shirohoo.ktcrud.member.adapter.out.RdbMemberCrudAdapter
import io.github.shirohoo.ktcrud.member.domain.Member
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/members")
class MemberController(private val repository: RdbMemberCrudAdapter) {
    @GetMapping
    fun findAll(): List<Member> = repository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Member = repository.findById(id)

    @PostMapping
    fun save(@RequestBody member: Member): Member = repository.save(member)

    @PutMapping
    fun update(@RequestBody member: Member): Member = repository.update(member)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = repository.deleteById(id)
}
