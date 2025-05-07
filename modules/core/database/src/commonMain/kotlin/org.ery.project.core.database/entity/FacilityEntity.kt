package org.ery.project.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facilities")
data class FacilityEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val duration: Int,
    val price: Float
)