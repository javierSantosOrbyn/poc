package com.example.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "document")
data class DocumentType(

    @Id
    @NotNull
    @Column(nullable = false, name = "doc_type_id")
    val docTypeId: String,

    @NotNull
    @Column(nullable = false, name = "name")
    val name: String,


    )

