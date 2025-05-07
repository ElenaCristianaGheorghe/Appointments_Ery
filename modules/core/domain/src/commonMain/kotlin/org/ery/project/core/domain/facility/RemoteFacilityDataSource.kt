package org.ery.project.core.domain.facility

import org.ery.project.core.domain.model.Facility
import org.ery.project.core.domain.model.FacilityBooked
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult
import org.ery.project.core.domain.util.Result

interface RemoteFacilityDataSource {
    suspend fun getFacilities(): Result<List<Facility>, DataError.Network>
    suspend fun postFacility(facility: Facility): Result<Facility, DataError.Network>
    suspend fun deleteFacility(facilityId: Long): EmptyResult<DataError.Network>
    suspend fun getFacilitiesBooked(): Result<List<FacilityBooked>, DataError.Network>
    suspend fun postFacilityBooked(facilityBooked: FacilityBooked): Result<FacilityBooked, DataError.Network>
    suspend fun deleteFacilityBooked(appointmentId: Long, facilityId: Long): EmptyResult<DataError.Network>
}