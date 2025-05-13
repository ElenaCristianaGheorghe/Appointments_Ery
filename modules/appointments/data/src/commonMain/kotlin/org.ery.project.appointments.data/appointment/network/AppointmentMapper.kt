package org.ery.project.appointments.data.appointment.network

import org.ery.project.core.domain.model.Appointment

fun NetworkAppointment.toAppointment(): Appointment {
    return Appointment(
        id = id,
        employeeId = employeeId,
        clientId = clientId,
        creationDate = creationDate,
        date = date,
        startTime = startTime,
        endTime = endTime
    )
}

fun Appointment.toNetworkAppointment(): NetworkAppointment {
    return NetworkAppointment(
        id = id,
        employeeId = employeeId,
        clientId = clientId,
        creationDate = creationDate,
        date = date,
        startTime = startTime,
        endTime = endTime
    )
}