package com.example.book.news

import java.io.Serializable

data class NewsItem (
    var id: Int = -1,
    var content: String = "",
    var title: String = "",
    var login: String = "",
    var picture: String = ""
): Serializable