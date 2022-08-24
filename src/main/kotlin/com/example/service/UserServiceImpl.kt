package com.example.service

import com.example.model.User
import com.example.model.UserRepository
import jakarta.inject.Singleton
import java.util.*

@Singleton
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun createUser(user: User) {
        val dbUser = user.copy(id = user.id ?: UUID.randomUUID())
        userRepository.save(dbUser)
    }

    override fun getAll(): List<User> {
        return userRepository.findAll()
    }

}