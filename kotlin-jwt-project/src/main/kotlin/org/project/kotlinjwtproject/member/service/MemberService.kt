package org.project.kotlinjwtproject.member.service

import jakarta.transaction.Transactional
import org.project.kotlinjwtproject.member.dto.MemberDtoRequest
import org.project.kotlinjwtproject.member.entity.Member
import org.project.kotlinjwtproject.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService (
    private val memberRepository: MemberRepository
    ){
    /*
    * 회원가입
    * */
    fun signUp(memberDtoRequest: MemberDtoRequest):String{
        //id 중복검사
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if(member != null){
            return "이미 등록된 ID 입니다."
        }

        member = Member(
            null,
            memberDtoRequest.loginId,
            memberDtoRequest.password,
            memberDtoRequest.name,
            memberDtoRequest.birthDate,
            memberDtoRequest.gender,
            memberDtoRequest.email
        )

        memberRepository.save(member)

        return "회원가입이 완료되었습니다."
    }
}