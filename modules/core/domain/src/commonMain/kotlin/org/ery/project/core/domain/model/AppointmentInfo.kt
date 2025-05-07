package org.ery.project.core.domain.model

data class AppointmentInfo(
    val date: String,
    val startTime: String,
    val endTime: String,
    val employeeName: String,
    val clientName: String,
    val clientPhone: String,
    val facilitiesBooked: List<String>
)