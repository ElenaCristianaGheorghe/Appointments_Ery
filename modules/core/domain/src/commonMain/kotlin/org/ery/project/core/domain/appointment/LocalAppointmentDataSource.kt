package org.ery.project.core.domain.appointment

import kotlinx.coroutines.flow.Flow
import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.model.AppointmentInfo
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

typealias AppointmentId = Int

interface LocalAppointmentDataSource {
    fun loadAppointmentsInfo(): Flow<List<AppointmentInfo>>
    suspend fun upsertAppointment(appointment: Appointment): Result<Long, DataError.Local>
    suspend fun upsertAppointments(appointments: List<Appointment>): Result<List<AppointmentId>, DataError.Local>
    suspend fun deleteAppointment(appointmentId: Long)
}