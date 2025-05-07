package org.ery.project.core.domain.appointment

import kotlinx.coroutines.flow.Flow
import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.model.AppointmentInfo
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult

interface AppointmentRepository {
    fun loadAppointments(): Flow<List<AppointmentInfo>>
    suspend fun fetchAppointments(): EmptyResult<DataError>
    suspend fun upsertAppointment(appointment: Appointment): EmptyResult<DataError>
    suspend fun deleteAppointment(appointmentId: Long)
}