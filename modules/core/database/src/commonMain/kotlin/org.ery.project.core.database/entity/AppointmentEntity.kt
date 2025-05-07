package org.ery.project.core.database.entity

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
        ForeignKey(entity = ClientEntity::class, parentColumns = ["id"], childColumns = ["client_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = EmployeeEntity::class, parentColumns = ["id"], childColumns = ["employee_id"], onDelete = ForeignKey.SET_DEFAULT)
    ]
)
data class AppointmentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "employee_id")
    val employeeId: Int?,
    @ColumnInfo(name = "client_id")
    val clientId: Int,
    @ColumnInfo(name = "creation_date")
    val creationDate: String = formatDateTime(LocalDateTime.now()),
    val date: String,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String
)