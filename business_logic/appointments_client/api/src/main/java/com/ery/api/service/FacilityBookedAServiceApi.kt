package com.ery.api.service

import com.ery.api.model.FacilityBooked

interface FacilityBookedAServiceApi {
    suspend fun addFacilityBooked(facilityBooked: FacilityBooked): FacilityBooked?
    suspend fun deleteFacilityBooked(id: Int): Boolean
    suspend fun getFacilityBooked(id: Int): FacilityBooked?
}