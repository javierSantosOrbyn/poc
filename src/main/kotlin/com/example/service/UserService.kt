package com.example.service

import com.example.model.User

interface UserService {

    fun createUser(user: User)

    fun getAll(): List<User>

}