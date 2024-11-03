package org.project.kotlinjwtproject.member.service

import jakarta.transaction.Transactional
import org.project.kotlinjwtproject.common.exception.InvalidInputException
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
            throw InvalidInputException("loginId", "이미 등록된 id입니다.")
        }

        member = memberDtoRequest.toEntity()

        memberRepository.save(member)

        return "회원가입이 완료되었습니다."
    }
}