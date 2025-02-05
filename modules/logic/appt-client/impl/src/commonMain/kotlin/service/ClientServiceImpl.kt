package org.ery.project.appointments_client.impl.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.ery.project.appointments_client.api.AppointmentsHttpRoutes
import org.ery.project.appointments_client.api.model.Client
import org.ery.project.appointments_client.api.service.ClientServiceApi

class ClientServiceImpl (private val ktorClient: HttpClient): ClientServiceApi {
    override suspend fun addClient(client: Client): Client? {
        return try {
            ktorClient.post(AppointmentsHttpRoutes.CLIENTS) {
                contentType(ContentType.Application.Json)
                setBody(client)
            }.body<Client>()
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: Exception) {
            println("Error: ${e.message}")
            null
        }
    }

    override suspend fun updateClient(client: Client): Boolean {
        return try {
            ktorClient.put(AppointmentsHttpRoutes.CLIENTS) {
                contentType(ContentType.Application.Json)
                setBody(client)
            }
            true
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            false
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            false
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            false
        } catch(e: Exception) {
            println("Error: ${e.message}")
            false
        }
    }

    override suspend fun getClient(id: Int): Client? {
        return try {
            ktorClient.get("${AppointmentsHttpRoutes.CLIENTS}?") {
                parameter("id", id)
            }.body<Client>()
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: Exception) {
            println("Error: ${e.message}")
            null
        }
    }

    override suspend fun getAllClients(): List<Client?> {
        return try {
            ktorClient.get(AppointmentsHttpRoutes.CLIENTS).body<List<Client>>()
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun deleteClient(id: Int): Boolean {
        return try {
            ktorClient.delete("${AppointmentsHttpRoutes.CLIENTS}?") {
                parameter("id", id)
            }
            true
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            false
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            false
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            false
        } catch(e: Exception) {
            println("Error: ${e.message}")
            false
        }
    }
}