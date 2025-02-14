package org.ery.project.appointments_client.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Client(
    val name: String,
    val phoneNumber: String,
    val id :Int = 0
)
