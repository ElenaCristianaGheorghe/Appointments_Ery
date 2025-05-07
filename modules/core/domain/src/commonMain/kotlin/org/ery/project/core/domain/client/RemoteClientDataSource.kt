package org.ery.project.core.domain.client

import org.ery.project.core.domain.model.Client
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult
import org.ery.project.core.domain.util.Result

interface RemoteClientDataSource {
    suspend fun getClients(): Result<List<Client>, DataError.Network>
    suspend fun postClient(client: Client): Result<Client, DataError.Network>
    suspend fun deleteClient(clientId: Long): EmptyResult<DataError.Network>
}