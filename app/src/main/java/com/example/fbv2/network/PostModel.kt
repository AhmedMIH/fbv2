package com.example.fbv2.network

import com.squareup.moshi.Json


class PostModel {

    @field:Json(name = "userId")
    var userId: Int = 0
    @field:Json(name = "id")
    var id: Int = 0
    @field:Json(name = "title")
    var title: String = ""
    @field:Json(name = "body")
    var body: String = ""
}