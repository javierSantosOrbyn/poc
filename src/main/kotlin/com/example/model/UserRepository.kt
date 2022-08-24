package com.example.model

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.GenericRepository

@Repository
interface UserRepository : GenericRepository<User, Long> {

    fun save(user: User)

    fun findAll(): List<User>

}


