package service

import org.ery.project.appointments_client.api.model.FacilityBooked

interface FacilityBookedAServiceApi {
    suspend fun addFacilityBooked(facilityBooked: FacilityBooked): FacilityBooked?
    suspend fun deleteFacilityBooked(id: Int): Boolean
    suspend fun getFacilityBooked(id: Int): FacilityBooked?
}