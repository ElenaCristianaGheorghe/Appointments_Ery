package org.ery.project.model

import androidx.room.ColumnInfo
import kotlinx.serialization.Serializable

@Serializable
data class FacilityBooked(
    val id: Int,
    @ColumnInfo(name = "service_id")
    val serviceId: Int,
    @ColumnInfo(name = "appointment_id")
    val appointmentId: Int,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "is_synced", defaultValue = "false")
    var isSynced: Boolean = false
)