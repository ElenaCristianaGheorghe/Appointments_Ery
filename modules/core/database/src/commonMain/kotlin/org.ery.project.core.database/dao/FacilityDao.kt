package org.ery.project.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.ery.project.core.database.entity.FacilityEntity

@Dao
interface FacilityDao {
    @Upsert
    suspend fun upsertFacility(facility: FacilityEntity): Long

    @Query("SELECT * FROM facilities")
    fun getFacilities(): List<FacilityEntity>

    @Query("SELECT * FROM facilities")
    fun loadFacilities(): Flow<List<FacilityEntity>>

    @Query("DELETE FROM facilities WHERE id = :id")
    suspend fun deleteFacility(id: Long)
}