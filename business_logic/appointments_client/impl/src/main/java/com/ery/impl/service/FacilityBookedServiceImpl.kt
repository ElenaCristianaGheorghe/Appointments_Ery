package com.ery.impl.service

import com.ery.api.HttpRoutes
import com.ery.api.model.FacilityBooked
import com.ery.api.service.FacilityBookedAServiceApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.delete
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class FacilityBookedServiceImpl @Inject constructor(private val ktorClient: HttpClient): FacilityBookedAServiceApi {
    override suspend fun addFacilityBooked(facilityBooked: FacilityBooked): FacilityBooked? {
        return try {
            ktorClient.post(HttpRoutes.CLIENTS) {
                contentType(ContentType.Application.Json)
                setBody(facilityBooked)
            }.body<FacilityBooked>()
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

    override suspend fun deleteFacilityBooked(id: Int): Boolean {
        return try {
            ktorClient.delete("${HttpRoutes.CLIENTS}?") {
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

    override suspend fun getFacilityBooked(id: Int): FacilityBooked? {
        TODO("Not yet implemented")
    }
}