package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.model.Facility

@Dao
interface FacilityDao {
    @Upsert
    suspend fun insertFacility(clients: List<Facility>)

    @Query("SELECT * FROM facilities")
    suspend fun getAllClients(): List<Facility>

    @Query("SELECT * FROM Facilities WHERE is_synced = 0")
    suspend fun getUnsyncedFacilities(): List<Facility> // Fetch local changes

    @Query("UPDATE Facilities SET is_synced = 1 WHERE id IN (:facilityIds)")
    suspend fun markFacilitiesAsSynced(facilityIds: List<Int>)

    @Query("DELETE FROM Facilitys WHERE id NOT IN (:facilityIds)")
    suspend fun deleteFacilitiesNotIn(facilityIds: List<Int>)
}