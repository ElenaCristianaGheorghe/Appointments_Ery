package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.entity.AppointmentEntity

@Dao
interface AppointmentDao {
    @Upsert
    suspend fun insertAppointments(clients: List<AppointmentEntity>)

    @Query("SELECT * FROM appointments")
    suspend fun getAllClients(): List<AppointmentEntity>

    @Query("SELECT * FROM appointments WHERE is_synced = 0")
    suspend fun getUnsyncedAppointments(): List<AppointmentEntity> // Fetch local changes

    @Query("UPDATE appointments SET is_synced = 1 WHERE id IN (:appointmentIds)")
    suspend fun markAppointmentsAsSynced(appointmentIds: List<Int>)

    @Query("DELETE FROM appointments WHERE id NOT IN (:appointmentIds)")
    suspend fun deleteAppointmentsNotIn(appointmentIds: List<Int>)
}