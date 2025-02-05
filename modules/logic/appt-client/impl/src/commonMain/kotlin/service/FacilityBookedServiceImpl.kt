package org.ery.project.appointments_client.impl.service

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
import org.ery.project.appointments_client.api.AppointmentsHttpRoutes
import org.ery.project.appointments_client.api.model.FacilityBooked
import service.FacilityBookedAServiceApi

class FacilityBookedServiceImpl (private val ktorClient: HttpClient): FacilityBookedAServiceApi {
    override suspend fun addFacilityBooked(facilityBooked: FacilityBooked): FacilityBooked? {
        return try {
            ktorClient.post(AppointmentsHttpRoutes.CLIENTS) {
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

    override suspend fun getFacilityBooked(id: Int): FacilityBooked? {
        TODO("Not yet implemented")
    }
}