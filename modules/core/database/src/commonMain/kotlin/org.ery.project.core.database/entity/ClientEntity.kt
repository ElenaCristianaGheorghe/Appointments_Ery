package org.ery.project.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "clients",
    foreignKeys = [
        ForeignKey(entity = AppointmentEntity::class, parentColumns = ["client_id"], childColumns = ["id"], onDelete = ForeignKey.CASCADE),
    ]
)
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String
)