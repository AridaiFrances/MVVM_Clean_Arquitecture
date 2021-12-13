package com.musicaengijon.mvvm_clean_arquitecture.patterns.builder

import com.musicaengijon.mvvm_clean_arquitecture.patterns.builder.UserType.COPPER

class User(
    val id: Int,
    val name: String,
    var secondName: String? = null,
    var email: String? = null,
    var userTyoe: UserType = COPPER
)

class UserForBuilderPattern private constructor(
    val id: Int,
    val name: String,
    val secondName: String?,
    val email: String?,
    val userTyoe: UserType
) {

    class Builder(
        val id: Int,
        val name: String
    ) {

        private var secondName: String? = null
        private var email: String? = null
        private var userTyoe: UserType = COPPER

        fun setSecondName(secondName: String) = apply {
            this.secondName = secondName
        }

        fun setEmail(email: String) = apply {
            this.email = email
        }

        fun setUserType(userTyoe: UserType) = apply {
            this.userTyoe = userTyoe
        }
        /**
         * This function is an example of how to use the Builder pattern
         **/
        fun build() = UserForBuilderPattern(id, name, secondName, email, userTyoe)
    }
}

enum class UserType {
    GOLD,
    SILVER,
    COPPER
}