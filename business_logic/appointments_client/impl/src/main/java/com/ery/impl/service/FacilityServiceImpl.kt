package com.ery.impl.service

import com.ery.api.HttpRoutes
import com.ery.api.model.Facility
import com.ery.api.service.FacilityServiceApi
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
import javax.inject.Inject

class FacilityServiceImpl @Inject constructor(private val ktorClient: HttpClient) : FacilityServiceApi {
    override suspend fun addFacility(facility: Facility): Facility? {
        return try {
            ktorClient.post(HttpRoutes.FACILITIES) {
                contentType(ContentType.Application.Json)
                setBody(facility)
            }.body<Facility>()
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

    override suspend fun updateFacility(facility: Facility): Boolean {
        return try {
            ktorClient.put(HttpRoutes.FACILITIES) {
                contentType(ContentType.Application.Json)
                setBody(facility)
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

    override suspend fun getFacility(id: Int): Facility? {
        return try {
            ktorClient.get("${HttpRoutes.FACILITIES}?") {
                parameter("id", id)
            }.body<Facility>()
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

    override suspend fun getAllFacilities(): List<Facility?> {
        return try {
            ktorClient.get(HttpRoutes.FACILITIES).body<List<Facility>>()
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

    override suspend fun deleteFacility(id: Int): Boolean {
        return try {
            ktorClient.delete("${HttpRoutes.FACILITIES}?") {
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