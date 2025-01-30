package com.ery.api.model

import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.Date

@Serializable
data class Appointment(
    val employeeId: Int?,
    val clientId: Int,
    val creationDate: String = SimpleDateFormat.getDateInstance().format(Date()),
    val cancelled: Boolean,
    val cancellationReason: String? = null,
    val createdByClient: Boolean = false,
    val startTime: String,
    val endTime: String,
    val id: Int = 0
)
