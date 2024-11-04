package org.project.kotlinjwtproject.member.service

import jakarta.transaction.Transactional
import org.project.kotlinjwtproject.common.authority.JwtTokenProvider
import org.project.kotlinjwtproject.common.authority.TokenInfo
import org.project.kotlinjwtproject.common.exception.InvalidInputException
import org.project.kotlinjwtproject.common.status.ROLE
import org.project.kotlinjwtproject.member.dto.LoginDto
import org.project.kotlinjwtproject.member.dto.MemberDtos
import org.project.kotlinjwtproject.member.entity.Member
import org.project.kotlinjwtproject.member.entity.MemberRole
import org.project.kotlinjwtproject.member.repository.MemberRepository
import org.project.kotlinjwtproject.member.repository.MemberRoleRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service
import java.lang.StringBuilder

@Transactional
@Service
class MemberService (
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository,
    private val authenticationManagetBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider

    ){
    /*
    * 회원가입
    * */
    fun signUp(memberDtoRequest: MemberDtos):String{
        //id 중복검사
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if(member != null){
            throw InvalidInputException("loginId", "이미 등록된 id입니다.")
        }

        member = memberDtoRequest.toEntity()

        memberRepository.save(member)

        val memberRole: MemberRole = MemberRole(null, ROLE.MEMBER, member)
        memberRoleRepository.save(memberRole)

        return "회원가입이 완료되었습니다."
    }

    /*
    * 로그인 -> 토큰 발행
    * */
    fun login(loginDto: LoginDto): TokenInfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.loginId, loginDto.password)
        val authentication = authenticationManagetBuilder.`object`.authenticate(authenticationToken)

        return jwtTokenProvider.createToken(authentication)
    }
}