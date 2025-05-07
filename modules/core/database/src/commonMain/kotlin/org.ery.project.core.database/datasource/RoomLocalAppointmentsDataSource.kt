package org.ery.project.core.database.datasource

import androidx.sqlite.SQLiteException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.ery.project.core.database.dao.AppointmentDao
import org.ery.project.core.database.mappers.toAppointmentEntity
import org.ery.project.core.database.mappers.toAppointmentInfo
import org.ery.project.core.domain.appointment.LocalAppointmentDataSource
import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.model.AppointmentInfo
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

class RoomLocalAppointmentsDataSource(
    private val appointmentDao: AppointmentDao
): LocalAppointmentDataSource {
    override fun loadAppointmentsInfo(): Flow<List<AppointmentInfo>> {
        return appointmentDao.loadAppointmentsInfo().map { appointmentInfoModels ->
            appointmentInfoModels.map { it.toAppointmentInfo() }
        }
    }

    override suspend fun upsertAppointment(appointment: Appointment): Result<Long, DataError.Local> {
        return try {
            val entity = appointment.toAppointmentEntity()
            val id = appointmentDao.upsertAppointment(entity)
            Result.Success(id)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteAppointment(appointmentId: Long) {
        appointmentDao.deleteAppointment(appointmentId)
    }
}