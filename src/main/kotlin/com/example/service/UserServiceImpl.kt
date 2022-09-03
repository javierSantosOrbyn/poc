package com.example.service

import com.example.config.KafkaClient
import com.example.model.User
import com.example.model.UserRepository
import jakarta.inject.Singleton

@Singleton
class UserServiceImpl(private val userRepository: UserRepository, private val kafkaClient: KafkaClient) : UserService {

    override fun createUser(user: User) {
        kafkaClient.sendUser(1, user)
    }

    override fun getAll(): List<User> {
        return userRepository.findAll()
    }

}