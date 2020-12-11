package com.rynn.tokoku.data.model

data class ActionState<T>(
    val data: T? = null,
    val message: String? = null,
    val isSuccess: Boolean = true,
    var isConsumd: Boolean = false
)
