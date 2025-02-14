package org.ery.project.service

import org.ery.project.model.Client

interface ClientServiceApi {
    suspend fun addClient(client: Client): Client?
    suspend fun updateClient(client: Client): Boolean
    suspend fun getClient(id: Int): Client?
    suspend fun getAllClients(): List<Client?>
    suspend fun deleteClient(id: Int): Boolean
}