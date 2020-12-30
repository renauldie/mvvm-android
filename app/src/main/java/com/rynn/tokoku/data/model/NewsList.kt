package com.rynn.tokoku.data.model

data class NewsList(
    val data: List<News> = arrayListOf(),
    val lenght: Int = 0,
    val status: Int = 0
)
