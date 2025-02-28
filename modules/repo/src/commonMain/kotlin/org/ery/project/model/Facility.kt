package org.ery.project.model

import androidx.room.ColumnInfo
import kotlinx.serialization.Serializable

@Serializable
data class Facility(
    val name: String,
    val duration: Int,
    val price: Float,
    val id :Int,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "is_synced", defaultValue = "false")
    var isSynced: Boolean = false

)
