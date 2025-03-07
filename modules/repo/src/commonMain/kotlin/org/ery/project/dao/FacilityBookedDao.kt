package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.entity.FacilityBookedEntity

@Dao
interface FacilityBookedDao {
    @Upsert
    suspend fun insertFacilityBooked(clients: List<FacilityBookedEntity>)

    @Query("SELECT * FROM facilities_booked")
    suspend fun getAllClients(): List<FacilityBookedEntity>

    @Query("SELECT * FROM facilities_booked WHERE is_synced = 0")
    suspend fun getUnsyncedFacilitiesBooked(): List<FacilityBookedEntity> // Fetch local changes

    @Query("UPDATE facilities_booked SET is_synced = 1 WHERE id IN (:facilityBookedIds)")
    suspend fun markFacilitiesBookedAsSynced(facilityBookedIds: List<Int>)

    @Query("DELETE FROM facilities_booked WHERE id NOT IN (:facilityBookedIds)")
    suspend fun deleteFacilitiesBookedNotIn(facilityBookedIds: List<Int>)
}