package org.ery.project.appointments_client.api.model

import kotlinx.serialization.Serializable

@Serializable
data class FacilityBooked(
    val serviceId: Int,
    val appointmentId: Int,
    val id: Int = 0
)