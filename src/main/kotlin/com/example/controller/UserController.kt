package com.example.controller

import com.example.model.User
import com.example.service.UserService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/user")
class UserController(@Inject val userService: UserService) {

    @Get("/")
    fun getAllUsers(): List<User> {
        return userService.getAll()
    }

    @Post(value = "/", produces = [MediaType.APPLICATION_JSON])
    fun add(@Body user: User) {
        userService.createUser(user)
    }

}