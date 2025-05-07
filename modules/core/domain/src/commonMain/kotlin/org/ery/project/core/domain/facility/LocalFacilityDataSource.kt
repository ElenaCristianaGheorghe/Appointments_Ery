package org.ery.project.core.domain.facility

import org.ery.project.core.domain.model.Facility
import org.ery.project.core.domain.model.FacilityBooked
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

interface LocalFacilityDataSource {
    suspend fun upsertFacility(facility: Facility): Result<Long, DataError.Local>
    suspend fun deleteFacility(facilityId: Long)
    suspend fun upsertFacilityBooked(facilityBooked: FacilityBooked): Result<Long, DataError.Local>
    suspend fun deleteFacilityBooked(appointmentId: Long, facilityId: Long)
}