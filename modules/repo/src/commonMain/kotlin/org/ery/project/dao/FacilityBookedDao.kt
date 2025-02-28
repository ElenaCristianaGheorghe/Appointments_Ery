package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.model.FacilityBooked

@Dao
interface FacilityBookedDao {
    @Upsert
    suspend fun insertFacilityBooked(clients: List<FacilityBooked>)

    @Query("SELECT * FROM facility_booked")
    suspend fun getAllClients(): List<FacilityBooked>

    @Query("SELECT * FROM facility_bookeds WHERE is_synced = 0")
    suspend fun getUnsyncedFacilitiesBooked(): List<FacilityBooked> // Fetch local changes

    @Query("UPDATE facility_bookeds SET is_synced = 1 WHERE id IN (:facilityBookedIds)")
    suspend fun markFacilitiesBookedAsSynced(facilityBookedIds: List<Int>)

    @Query("DELETE FROM FacilityBookeds WHERE id NOT IN (:facilityBookedIds)")
    suspend fun deleteFacilitiesBookedNotIn(facilityBookedIds: List<Int>)
}