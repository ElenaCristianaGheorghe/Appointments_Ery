package org.ery.project.appointments.data.appointment

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import org.ery.project.core.domain.appointment.AppointmentRepository
import org.ery.project.core.domain.appointment.LocalAppointmentDataSource
import org.ery.project.core.domain.appointment.RemoteAppointmentDataSource
import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.model.AppointmentInfo
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult
import org.ery.project.core.domain.util.Result
import org.ery.project.core.domain.util.asEmptyDataResult

class AppointmentRepositoryImpl(
    private val localAppointmentsDataSource: LocalAppointmentDataSource,
    private val remoteAppointmentDataSource: RemoteAppointmentDataSource,
    private val applicationScope: CoroutineScope

): AppointmentRepository {
    override fun loadAppointments(): Flow<List<AppointmentInfo>> {
        return localAppointmentsDataSource.loadAppointmentsInfo()
    }

    override suspend fun fetchAppointments(): EmptyResult<DataError> {
        return when (val result = remoteAppointmentDataSource.getAppointments()) {
            is Result.Error -> result.asEmptyDataResult()
            is Result.Success -> {
                applicationScope.async {
                    localAppointmentsDataSource.upsertAppointments(result.data).asEmptyDataResult()
                }.await()
            }
        }
    }

    override suspend fun upsertAppointment(appointment: Appointment): EmptyResult<DataError> {
        val localResult = localAppointmentsDataSource.upsertAppointment(appointment)
        if (localResult is DataError) {
            return localResult.asEmptyDataResult()
        }

        val remoteResult = applicationScope.async {
            remoteAppointmentDataSource.postAppointment(appointment).asEmptyDataResult()
        }.await()

        //Todo(add sync)

        return remoteResult

    }

    override suspend fun deleteAppointment(appointmentId: Long) {
        localAppointmentsDataSource.deleteAppointment(appointmentId)

        applicationScope.async {
            remoteAppointmentDataSource.deleteAppointment(appointmentId)
        }.await()

        //Todo(add sync)
    }
}