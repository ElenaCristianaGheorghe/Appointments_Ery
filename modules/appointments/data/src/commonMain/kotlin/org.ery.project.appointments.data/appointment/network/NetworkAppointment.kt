package org.ery.project.appointments.data.appointment.network

import kotlinx.serialization.Serializable

@Serializable
data class NetworkAppointment(
    val id: Long = 0,
    val employeeId: Int?,
    val clientId: Int,
    val creationDate: String,
    val date: String,
    val startTime: String,
    val endTime: String,
)