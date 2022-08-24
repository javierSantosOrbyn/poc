package com.example.controller

import com.example.model.User
import com.example.model.UserRepository
import com.example.service.UserService
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

@MicronautTest
class UserControllerTest {

    val userService = Mockito.mock(UserService::class.java)

    val userController: UserController = UserController(userService)

    @Test
    fun getAllUsers(){
        val userOne = User(UUID.randomUUID(), "Pepe", 43)
        val userTwo = User(UUID.randomUUID(), "Javier", 23)
        val listUsers = listOf<User>(userOne, userTwo)
        Mockito.`when`(userService.getAll()).thenReturn(listUsers)

        val response = userController.getAllUsers()

        Mockito.verify(userService, Mockito.times(1)).getAll()
        Assertions.assertEquals(userOne, response[0])
        Assertions.assertEquals(userTwo, response[1])
    }

    @Test
    fun addUser(){
        val user = User(UUID.randomUUID(), "Pepe", 43)
        userController.add(user)
        Mockito.verify(userService, Mockito.times(1)).createUser(user)
    }

}