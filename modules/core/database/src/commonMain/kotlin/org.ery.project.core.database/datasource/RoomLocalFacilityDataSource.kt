package org.ery.project.core.database.datasource

import androidx.sqlite.SQLiteException
import org.ery.project.core.database.dao.FacilityBookedDao
import org.ery.project.core.database.dao.FacilityDao
import org.ery.project.core.database.mappers.toFacilityBookedEntity
import org.ery.project.core.database.mappers.toFacilityEntity
import org.ery.project.core.domain.facility.LocalFacilityDataSource
import org.ery.project.core.domain.model.Facility
import org.ery.project.core.domain.model.FacilityBooked
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

class RoomLocalFacilityDataSource(
    private val facilityDao: FacilityDao,
    private val facilityBookedDao: FacilityBookedDao
): LocalFacilityDataSource {
    override suspend fun upsertFacility(facility: Facility): Result<Long, DataError.Local> {
        return try {
            val entity = facility.toFacilityEntity()
            val id = facilityDao.upsertFacility(entity)
            Result.Success(id)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFacility(facilityId: Long) {
        facilityDao.deleteFacility(facilityId)
    }

    override suspend fun upsertFacilityBooked(facilityBooked: FacilityBooked): Result<Long, DataError.Local> {
        return try {
            val entity = facilityBooked.toFacilityBookedEntity()
            val id = facilityBookedDao.upsertFacilityBooked(entity)
            Result.Success(id)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFacilityBooked(appointmentId: Long, facilityId: Long) {
        facilityBookedDao.deleteFacilityBooked(
            appointmentId = appointmentId,
            facilityId = facilityId
        )
    }
}