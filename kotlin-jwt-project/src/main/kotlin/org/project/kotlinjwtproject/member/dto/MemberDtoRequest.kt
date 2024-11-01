package org.project.kotlinjwtproject.member.dto

import org.project.kotlinjwtproject.common.status.Gender
import java.time.LocalDate

data class MemberDtoRequest (
    val id: Long?,
    val loginId: String,
    val password: String,
    val name: String,
    val birthDate: LocalDate,
    val gender: Gender,
    val email: String,
)