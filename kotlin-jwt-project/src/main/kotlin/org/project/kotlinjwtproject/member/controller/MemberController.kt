package org.project.kotlinjwtproject.member.controller

import jakarta.validation.Valid
import org.project.kotlinjwtproject.common.authority.TokenInfo
import org.project.kotlinjwtproject.common.dto.BaseResponse
import org.project.kotlinjwtproject.member.dto.LoginDto
import org.project.kotlinjwtproject.member.dto.MemberDtos
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
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtos): BaseResponse<Unit>{
        val resultMsg: String = memberService.signUp(memberDtoRequest)
        return BaseResponse(message = resultMsg)
    }

    /*
    * 로그인
    * */
    @PostMapping("/login")
    fun login(@RequestBody @Valid loginDto: LoginDto): BaseResponse<TokenInfo>{
        val tokenInfo = memberService.login(loginDto)
        return BaseResponse(data = tokenInfo)
    }

}