package service

import org.ery.project.appointments_client.api.model.Facility

interface FacilityServiceApi {
    suspend fun addFacility(facility: Facility): Facility?
    suspend fun updateFacility(facility: Facility): Boolean
    suspend fun getFacility(id: Int): Facility?
    suspend fun getAllFacilities(): List<Facility?>
    suspend fun deleteFacility(id: Int): Boolean
}