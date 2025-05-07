package org.ery.project.core.domain.appointment

import kotlinx.coroutines.flow.Flow
import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.model.AppointmentInfo
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

interface LocalAppointmentDataSource {
    fun loadAppointmentsInfo(): Flow<List<AppointmentInfo>>
    suspend fun upsertAppointment(appointment: Appointment): Result<Long, DataError.Local>
    suspend fun deleteAppointment(appointmentId: Long)


}