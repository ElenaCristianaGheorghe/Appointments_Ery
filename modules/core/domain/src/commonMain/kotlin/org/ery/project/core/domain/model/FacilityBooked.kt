package org.ery.project.core.domain.model

data class FacilityBooked(
    val id: Long = 0,
    //TODO(update the api)
    val facilityId: Int,
    val appointmentId: Int
)
