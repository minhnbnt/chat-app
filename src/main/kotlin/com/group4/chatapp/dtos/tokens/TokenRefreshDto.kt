package com.group4.chatapp.dtos.tokens

import jakarta.validation.constraints.NotEmpty

data class TokenRefreshDto(

    @field:NotEmpty
    val refresh: String
)