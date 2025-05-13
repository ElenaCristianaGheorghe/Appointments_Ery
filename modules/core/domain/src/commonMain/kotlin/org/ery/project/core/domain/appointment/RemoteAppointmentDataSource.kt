package org.ery.project.core.domain.appointment

import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult
import org.ery.project.core.domain.util.Result

interface RemoteAppointmentDataSource {
    suspend fun getAppointments(): Result<List<Appointment>, DataError.Network>
    suspend fun postAppointment(appointment: Appointment): EmptyResult<DataError.Network>
    suspend fun deleteAppointment(appointmentId: Long): EmptyResult<DataError.Network>
}