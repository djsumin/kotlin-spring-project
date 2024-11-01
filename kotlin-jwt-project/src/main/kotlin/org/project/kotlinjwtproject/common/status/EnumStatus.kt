package org.project.kotlinjwtproject.common.status;

enum class Gender(val desc: String){
    MAN("남"),
    WOMAN("여")
}

enum class ResultCode(val code: String){
    SUCCESS("정상 처리 되었습니다."),
    ERROR("에러가 발생했습니다.")
}