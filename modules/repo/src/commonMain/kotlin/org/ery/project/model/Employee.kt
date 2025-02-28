package org.ery.project.model

import androidx.room.ColumnInfo
import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val id :Int,
    val name: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "email_address")
    val emailAddress: String,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "is_synced", defaultValue = "false")
    var isSynced: Boolean = false
)
