package org.ery.project.service

import org.ery.project.model.FacilityBooked

interface FacilityBookedAServiceApi {
    suspend fun addFacilityBooked(facilityBooked: FacilityBooked): FacilityBooked?
    suspend fun deleteFacilityBooked(id: Int): Boolean
    suspend fun getFacilityBooked(id: Int): FacilityBooked?
}