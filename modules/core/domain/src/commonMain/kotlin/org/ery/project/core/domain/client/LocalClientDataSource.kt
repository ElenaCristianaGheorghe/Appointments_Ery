package org.ery.project.core.domain.client

import org.ery.project.core.domain.model.Client
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

interface LocalClientDataSource {
    suspend fun upsertClient(client: Client): Result<Long, DataError.Local>
    suspend fun deleteEmployee(clientId: Long)
}