package com.test.medpersonal.domain.models

data class User(
    var uid: String? = null,
    var name: String? = null,
    var phoneNumber: String? = null,
    var profileImage: String? = null
)

data class User2(
    val name : String? = null,
    val message : String? = null
)