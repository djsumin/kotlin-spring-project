package org.project.kotlinjwtproject.member.repository

import org.project.kotlinjwtproject.member.entity.Member
import org.project.kotlinjwtproject.member.entity.MemberRole
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByLoginId(loginId: String): Member?

}

interface MemberRoleRepository : JpaRepository<MemberRole, Long>