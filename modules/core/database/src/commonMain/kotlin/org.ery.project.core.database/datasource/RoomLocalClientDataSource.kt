package org.ery.project.core.database.datasource

import androidx.sqlite.SQLiteException
import org.ery.project.core.database.dao.ClientDao
import org.ery.project.core.database.mappers.toClientEntity
import org.ery.project.core.domain.client.LocalClientDataSource
import org.ery.project.core.domain.model.Client
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

class RoomLocalClientDataSource(
    private val clientDao: ClientDao
): LocalClientDataSource {
    override suspend fun upsertClient(client: Client): Result<Long, DataError.Local> {
        return try {
            val entity = client.toClientEntity()
            val id = clientDao.upsertClient(entity)
            Result.Success(id)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteEmployee(clientId: Long) {
        clientDao.deleteClient(clientId)
    }
}