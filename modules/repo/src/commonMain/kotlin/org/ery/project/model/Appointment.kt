package org.ery.project.model

import androidx.room.ColumnInfo
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import org.ery.project.datetime.formatDateTime
import org.ery.project.datetime.now

@Serializable
data class Appointment(
    val id: Int,
    @ColumnInfo(name = "employee_id")
    val employeeId: Int?,
    @ColumnInfo(name = "client_id")
    val clientId: Int,
    @ColumnInfo(name = "creation_date")
    val creationDate: String = formatDateTime(LocalDateTime.now()),
    @ColumnInfo(name = "cancelled")
    val cancelled: Boolean,
    @ColumnInfo(name = "cancellation_reason", defaultValue = "NULL")
    val cancellationReason: String? = null,
    @ColumnInfo(name = "created_by_client", defaultValue = "false")
    val createdByClient: Boolean = false,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "is_synced", defaultValue = "false")
    var isSynced: Boolean = false
)