package org.ery.project.core.database.mappers

import org.ery.project.core.database.entity.AppointmentEntity
import org.ery.project.core.database.entity.ClientEntity
import org.ery.project.core.database.entity.EmployeeEntity
import org.ery.project.core.database.entity.FacilityBookedEntity
import org.ery.project.core.database.entity.FacilityEntity
import org.ery.project.core.database.model.AppointmentInfoModel
import org.ery.project.core.domain.model.Appointment
import org.ery.project.core.domain.model.AppointmentInfo
import org.ery.project.core.domain.model.Client
import org.ery.project.core.domain.model.Employee
import org.ery.project.core.domain.model.Facility
import org.ery.project.core.domain.model.FacilityBooked

fun AppointmentInfoModel.toAppointmentInfo(): AppointmentInfo {
    return AppointmentInfo(
        date = date,
        startTime = startTime,
        endTime = endTime,
        employeeName = employeeName,
        clientName = clientName,
        clientPhone = clientPhone,
        facilitiesBooked = facilitiesBooked
    )
}

fun AppointmentEntity.toAppointment(): Appointment {
    return Appointment(
        id = id,
        employeeId = employeeId,
        clientId = clientId,
        date = date,
        startTime = startTime,
        endTime = endTime,
        creationDate = creationDate
    )
}

fun Appointment.toAppointmentEntity(): AppointmentEntity {
    return AppointmentEntity(
        id = id,
        employeeId = employeeId,
        clientId = clientId,
        creationDate = creationDate,
        date = date,
        startTime = startTime,
        endTime = endTime
    )
}

fun ClientEntity.toClient(): Client {
    return Client(
        id = id,
        name = name,
        phoneNumber = phoneNumber
    )
}

fun Client.toClientEntity(): ClientEntity {
    return ClientEntity(
        id = id,
        name = name,
        phoneNumber = phoneNumber
    )
}

fun EmployeeEntity.toEmployee(): Employee {
    return Employee(
        id = id,
        name = name,
        phoneNumber = phoneNumber
    )
}

fun Employee.toEmployeeEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = id,
        name = name,
        phoneNumber = phoneNumber
    )
}

fun Facility.toFacilityEntity(): FacilityEntity {
    return FacilityEntity(
        id = id,
        name = name,
        duration = duration,
        price = price
    )
}

fun FacilityEntity.toFacility(): Facility {
    return Facility(
        id = id,
        name = name,
        duration = duration,
        price = price
    )
}

fun FacilityBookedEntity.toFacilityBooked(): FacilityBooked {
    return FacilityBooked(
        id = id,
        facilityId = facilityId,
        appointmentId = appointmentId
    )
}

fun FacilityBooked.toFacilityBookedEntity(): FacilityBookedEntity {
    return FacilityBookedEntity(
        id = id,
        facilityId = facilityId,
        appointmentId = appointmentId
    )
}

