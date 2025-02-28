package org.ery.project.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "facilities_booked",
    foreignKeys = [
        ForeignKey(entity = FacilityEntity::class, parentColumns = ["_id"], childColumns = ["service_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = AppointmentEntity::class, parentColumns = ["_id"], childColumns = ["appointment_id"], onDelete = ForeignKey.CASCADE)
    ]
)
data class FacilityBookedEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "service_id")
    val serviceId: Int,
    @ColumnInfo(name = "appointment_id")
    val appointmentId: Int,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "is_synced", defaultValue = "false")
    var isSynced: Boolean = false
)