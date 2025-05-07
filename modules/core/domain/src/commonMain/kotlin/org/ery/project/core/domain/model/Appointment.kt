package org.ery.project.core.domain.model

data class Appointment(
    val id: Long = 0,
    val employeeId: Int?,
    val clientId: Int,
    val creationDate: String,
    val date: String,
    val startTime: String,
    val endTime: String,
)