package com.group4.chatapp.dtos

import jakarta.validation.constraints.NotEmpty


data class UserDto(

    @field:NotEmpty
    val username: String,

    @field:NotEmpty
    val password: String
)