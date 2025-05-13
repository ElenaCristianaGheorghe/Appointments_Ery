package org.ery.project.core.domain.client

import org.ery.project.core.domain.model.Client
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult

interface ClientRepository {
    suspend fun upsertClient(client: Client): EmptyResult<DataError>
    suspend fun deleteClient(clientId: Long)
}