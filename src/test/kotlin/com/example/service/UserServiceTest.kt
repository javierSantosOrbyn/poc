//package com.example.service
//
//import com.example.config.KafkaClient
//import com.example.model.User
//import com.example.model.UserRepository
//import io.micronaut.test.extensions.junit5.annotation.MicronautTest
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.Test
//import org.mockito.Mockito
//import org.mockito.Mockito.*
//import java.util.*
//
//@MicronautTest
//class UserServiceTest {
//
//    val userRepository = Mockito.mock(UserRepository::class.java)
//    val kafkaClient = Mockito.mock(KafkaClient::class.java)
//
//    val userService: UserService = UserServiceImpl(userRepository, kafkaClient)
//
//    @Test
//    fun createUser() {
//        val user = User(UUID.randomUUID(), "Pepe", 23)
//        userService.createUser(user)
//        verify(userRepository, times(1)).save(user)
//    }
//
//    @Test
//    fun getAllUsers() {
//        val userOne = User(UUID.randomUUID(), "Pepe", 43)
//        val userTwo = User(UUID.randomUUID(), "Javier", 23)
//        val listUsers = listOf<User>(userOne, userTwo)
//        `when`(userRepository.findAll()).thenReturn(listUsers)
//
//        val response = userService.getAll()
//
//        verify(userRepository, times(1)).findAll()
//        Assertions.assertEquals(userOne, response[0])
//        Assertions.assertEquals(userTwo, response[1])
//    }
//
//
//}