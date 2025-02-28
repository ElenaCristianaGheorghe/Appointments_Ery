package org.ery.project.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import org.ery.project.datetime.formatDateTime
import org.ery.project.datetime.now

@Entity(
    tableName = "appointments",
    foreignKeys = [
        ForeignKey(entity = ClientEntity::class, parentColumns = ["_id"], childColumns = ["client_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = EmployeeEntity::class, parentColumns = ["_id"], childColumns = ["employee_id"], onDelete = ForeignKey.SET_DEFAULT)
    ]
)
data class AppointmentEntity(
    @PrimaryKey val id: Int,
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