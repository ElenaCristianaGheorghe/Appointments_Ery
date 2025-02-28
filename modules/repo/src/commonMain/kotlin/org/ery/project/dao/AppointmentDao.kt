package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.model.Appointment

@Dao
interface AppointmentDao {
    @Upsert
    suspend fun insertAppointments(clients: List<Appointment>)

    @Query("SELECT * FROM appointments")
    suspend fun getAllClients(): List<Appointment>

    @Query("SELECT * FROM appointments WHERE is_synced = 0")
    suspend fun getUnsyncedAppointments(): List<Appointment> // Fetch local changes

    @Query("UPDATE appointments SET is_synced = 1 WHERE id IN (:appointmentIds)")
    suspend fun markAppointmentsAsSynced(appointmentIds: List<Int>)

    @Query("DELETE FROM appointments WHERE id NOT IN (:appointmentIds)")
    suspend fun deleteAppointmentsNotIn(appointmentIds: List<Int>)
}