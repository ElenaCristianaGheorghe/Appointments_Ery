package org.ery.project.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.core.database.entity.FacilityBookedEntity

@Dao
interface FacilityBookedDao {
    @Upsert
    suspend fun upsertFacilityBooked(facilityBooked: FacilityBookedEntity): Long

    @Query("SELECT * FROM facilities_booked")
    suspend fun getFacilitiesBooked(): List<FacilityBookedEntity>

    @Query("DELETE FROM facilities_booked WHERE facility_id = :facilityId AND appointment_id = :appointmentId")
    suspend fun deleteFacilityBooked(appointmentId: Long, facilityId: Long)
}