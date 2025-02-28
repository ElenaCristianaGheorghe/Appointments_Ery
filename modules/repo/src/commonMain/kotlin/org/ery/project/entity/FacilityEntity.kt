package org.ery.project.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facilities")
data class FacilityEntity(
    @PrimaryKey val id :Int = 0,
    val name: String,
    val duration: Int,
    val price: Float,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "is_synced", defaultValue = "false")
    var isSynced: Boolean = false
)