package com.group4.chatapp.services

import com.group4.chatapp.dtos.UserDto
import com.group4.chatapp.models.User
import com.group4.chatapp.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class UserService
@Autowired constructor(

    val repository: UserRepository,
    val passwordEncoder: PasswordEncoder

) {

    fun createUser(dto: UserDto) {

        val (username, password) = dto

        if (repository.existsByUsername(username)) {
            throw ResponseStatusException(
                HttpStatus.CONFLICT,
                "Username already exists. Please try a different one."
            )
        }

        val user = User(
            username = username,
            password = passwordEncoder.encode(password)
        )

        repository.save(user)
    }

    fun getUserByAuthentication(authentication: Authentication?) =
        authentication?.principal as? User
}