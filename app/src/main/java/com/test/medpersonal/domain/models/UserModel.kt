package com.test.medpersonal.domain.models

data class UserModel(
    var uid: String? = null,
    var name: String? = null,
    var image: String? = null
)
data class MessageModel(
    var name: String? = null,
    var message: String? = null,
)
