package com.example.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "public.user")
data class User(

    @Id
    val id: UUID?,

    @NotNull
    @Column(nullable = false)
    val name: String,

    @NotNull
    @Column(nullable = false)
    val age: Int


)

