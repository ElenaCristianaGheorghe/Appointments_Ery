package org.ery.project.model

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val name: String,
    val phoneNumber: String,
    val emailAddress: String,
    val id :Int = 0
)
