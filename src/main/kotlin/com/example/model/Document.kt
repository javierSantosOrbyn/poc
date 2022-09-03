package com.example.model

import java.sql.Date
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "document")
data class Document(

    @Id
    val id: UUID?,

    @NotNull
    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("id")
    val userId: User,

    @NotNull
    @JoinColumn(nullable = false, name = "doc_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("doc_type_id")
    val docTypeId: DocumentType,

    @NotNull
    @Column(nullable = false, name = "name")
    val name: String,

    @NotNull
    @Column(nullable = false)
    val size: Double,

    @NotNull
    @Column(nullable = false, name = "inner_url")
    val innerUrl: String,

    @NotNull
    @Column(nullable = false, name = "created_at")
    val createdAt: Date,

    @NotNull
    @Column(nullable = false, name = "updated_at")
    val updatedAt: Date



)

