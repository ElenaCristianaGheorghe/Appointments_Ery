package org.ery.project.core.domain.facility

import kotlinx.coroutines.flow.Flow
import org.ery.project.core.domain.model.Facility
import org.ery.project.core.domain.model.FacilityBooked
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult

interface FacilityRepository {
    fun loadFacility(): Flow<List<Facility>>
    fun fetchFacilities(): EmptyResult<DataError>
    fun upsertFacility(facility: Facility): EmptyResult<DataError>
    fun deleteFacility(facilityId: Long)
    fun loadFacilitiesBooked(): Flow<List<FacilityBooked>>
    fun fetchFacilitiesBooked(): EmptyResult<DataError>
    fun upsertFacilityBooked(): EmptyResult<DataError>
    fun deleteFacilityBooked(appointmentId: Long, facilityId: Long)
}