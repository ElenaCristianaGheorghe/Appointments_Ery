package org.ery.project.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "facilities_booked",
    foreignKeys = [
        ForeignKey(entity = FacilityEntity::class, parentColumns = ["id"], childColumns = ["facility_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = AppointmentEntity::class, parentColumns = ["id"], childColumns = ["appointment_id"], onDelete = ForeignKey.CASCADE)
    ]
)
data class FacilityBookedEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "facility_id")
    val facilityId: Int,
    @ColumnInfo(name = "appointment_id")
    val appointmentId: Int
)