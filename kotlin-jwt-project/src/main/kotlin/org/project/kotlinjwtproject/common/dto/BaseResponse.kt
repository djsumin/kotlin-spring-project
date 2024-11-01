package org.project.kotlinjwtproject.common.dto

import org.project.kotlinjwtproject.common.status.ResultCode

data class BaseResponse<T>(
    val resultCode: String = ResultCode.SUCCESS.name,
    val data: T? = null,
    val message: String = ResultCode.SUCCESS.code,
)
