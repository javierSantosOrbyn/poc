package com.example.model

import java.sql.Date
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "user")
data class User(

    @Id
    val id: UUID?,

    @NotNull
    @Column(nullable = false)
    val channel: String,

    @NotNull
    @Column(nullable = false)
    val email: String,

    @NotNull
    @Column(nullable = false)
    val phone: String,

    @NotNull
    @Column(nullable = false, name = "phone_prefix")
    val phonePefix: String,

    @NotNull
    @Column(nullable = false, name = "created_at")
    val createdAt: Date,

    @NotNull
    @Column(nullable = false, name = "updated_at")
    val updatedAt: Date


)

