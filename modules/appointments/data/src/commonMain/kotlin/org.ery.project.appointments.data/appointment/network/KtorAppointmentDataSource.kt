package org.ery.project.appointments.data.appointment.network

import io.ktor.client.HttpClient
import org.ery.project.core.data.network.HttpRoutes.APPOINTMENTS
import org.ery.project.core.data.network.delete
import org.ery.project.core.data.network.get
import org.ery.project.core.data.network.post
import org.ery.project.core.domain.appointment.RemoteAppointmentDataSource
import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult
import org.ery.project.core.domain.util.Result
import org.ery.project.core.domain.util.map

class KtorAppointmentDataSource(
    private val httpClient: HttpClient
): RemoteAppointmentDataSource {
    override suspend fun getAppointments(): Result<List<Appointment>, DataError.Network> {
        return httpClient.get<List<NetworkAppointment>>(route = APPOINTMENTS)
            .map { appointments -> appointments.map { it.toAppointment() }
        }
    }

    override suspend fun postAppointment(appointment: Appointment): EmptyResult<DataError.Network> {
        return httpClient.post<NetworkAppointment, Unit>(
            route = APPOINTMENTS,
            body = appointment.toNetworkAppointment()
        )
    }

    override suspend fun deleteAppointment(appointmentId: Long): EmptyResult<DataError.Network> {
        return httpClient.delete(
            route = APPOINTMENTS,
            queryParameters = mapOf(
                "id" to appointmentId
            )
        )
    }
}