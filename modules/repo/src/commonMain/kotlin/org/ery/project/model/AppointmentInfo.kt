package org.ery.project.model

import androidx.room.DatabaseView
import kotlinx.serialization.Serializable

@Serializable
@DatabaseView(
    viewName = "appointments_info_view",
    value = "SELECT A.start_time, A.end_time, E.name, C.name, C.phone_number, GROUP_CONCAT(F.name, ', ') " +
            "FROM appointments A " +
            "INNER JOIN employees E ON (E.id = A.employee_id) " +
            "INNER JOIN clients C on (C.id = A.client_id) " +
            "INNER JOIN facilities_booked FB on (FB.appointment_id = A.id) " +
            "INNER JOIN facilities F on (F.id = FB.service_id)"
)
data class AppointmentInfo(
    val startTime: String,
    val endTime: String,
    val employeeName: String,
    val clientName: String,
    val clientPhone: String,
    val facilitiesBooked: List<String>
)