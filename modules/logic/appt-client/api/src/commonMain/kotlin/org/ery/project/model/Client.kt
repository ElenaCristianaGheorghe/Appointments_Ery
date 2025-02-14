package org.ery.project.model

import kotlinx.serialization.Serializable

@Serializable
data class Client(
    val name: String,
    val phoneNumber: String,
    val id :Int = 0
)
