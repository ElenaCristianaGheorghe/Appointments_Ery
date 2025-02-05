package org.ery.project.appointments_client.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Facility(
    val name: String,
    val duration: Int,
    val price: Float,
    val id :Int = 0
)
