package org.ery.project.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.core.database.entity.ClientEntity

@Dao
interface ClientDao {
    @Upsert
    suspend fun upsertClient(client: ClientEntity): Long

    @Query("SELECT * FROM clients")
    fun getClients(): List<ClientEntity>

    @Query("DELETE FROM clients WHERE id = :id")
    suspend fun deleteClient(id: Long)
}