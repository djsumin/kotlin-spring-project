package org.project.kotlinjwtproject.member.controller

import jakarta.validation.Valid
import org.project.kotlinjwtproject.member.dto.MemberDtoRequest
import org.project.kotlinjwtproject.member.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController (
    private val memberService: MemberService
){
    /*
    * 회원가입
    */
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): String{
        return memberService.signUp(memberDtoRequest)
    }
}