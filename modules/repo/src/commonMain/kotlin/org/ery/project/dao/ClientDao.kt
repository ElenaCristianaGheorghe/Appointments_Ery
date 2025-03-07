package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.entity.ClientEntity

@Dao
interface ClientDao {
    @Upsert
    suspend fun insertClients(clients: List<ClientEntity>)

    @Query("SELECT * FROM clients")
    suspend fun getAllClients(): List<ClientEntity>

    @Query("SELECT * FROM clients WHERE is_synced = 0")
    suspend fun getUnsyncedClients(): List<ClientEntity> // Fetch local changes

    @Query("UPDATE clients SET is_synced = 1 WHERE id IN (:clientIds)")
    suspend fun markClientsAsSynced(clientIds: List<Int>)

    @Query("DELETE FROM clients WHERE id NOT IN (:clientIds)")
    suspend fun deleteClientsNotIn(clientIds: List<Int>)
}