package service

import org.ery.project.appointments_client.api.model.Appointment
import org.ery.project.appointments_client.api.model.AppointmentInfo

interface AppointmentServiceApi {
    suspend fun addAppointment(appointment: Appointment): Appointment?
    suspend fun updateAppointment(appointment: Appointment): Boolean
    suspend fun deleteAppointment(id: Int): Boolean
    suspend fun getAppointment(id: Int): Appointment?
    suspend fun getAllAppointments(): List<Appointment?>
    suspend fun getAppointmentInfo(id: Int): AppointmentInfo?
}