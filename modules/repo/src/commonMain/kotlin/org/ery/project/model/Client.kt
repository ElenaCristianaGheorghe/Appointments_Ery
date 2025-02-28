package org.ery.project.model

import androidx.room.ColumnInfo
import kotlinx.serialization.Serializable

@Serializable
data class Client(
    val id: Int,
    val name: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "is_synced", defaultValue = "false")
    var isSynced: Boolean = false
)
