package org.ery.project.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.ery.project.core.database.entity.AppointmentEntity
import org.ery.project.core.database.model.AppointmentInfoModel

@Dao
interface AppointmentDao {
    @Upsert
    suspend fun upsertAppointment(appointment: AppointmentEntity): Long

    @Query("SELECT * FROM appointments")
    fun getAppointments(): List<AppointmentEntity>

    @Query("SELECT * FROM appointments_info_view")
    fun loadAppointmentsInfo(): Flow<List<AppointmentInfoModel>>

    @Query("DELETE FROM appointments WHERE id = :id")
    suspend fun deleteAppointment(id: Long)
}