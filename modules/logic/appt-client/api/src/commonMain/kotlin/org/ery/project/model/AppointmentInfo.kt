package org.ery.project.model

import kotlinx.serialization.Serializable

@Serializable
data class AppointmentInfo(
    val employeeName: String,
    val clientName: String,
    val clientPhone: String,
    val startTime: String,
    val endTime: String,
    val facilitiesBooked: List<String>
)
