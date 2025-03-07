package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.entity.FacilityEntity

@Dao
interface FacilityDao {
    @Upsert
    suspend fun insertFacility(clients: List<FacilityEntity>)

    @Query("SELECT * FROM facilities")
    suspend fun getAllClients(): List<FacilityEntity>

    @Query("SELECT * FROM facilities WHERE is_synced = 0")
    suspend fun getUnsyncedFacilities(): List<FacilityEntity> // Fetch local changes

    @Query("UPDATE facilities SET is_synced = 1 WHERE id IN (:facilityIds)")
    suspend fun markFacilitiesAsSynced(facilityIds: List<Int>)

    @Query("DELETE FROM facilities WHERE id NOT IN (:facilityIds)")
    suspend fun deleteFacilitiesNotIn(facilityIds: List<Int>)
}