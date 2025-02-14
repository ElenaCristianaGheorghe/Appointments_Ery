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
import org.ery.project.appointments_client.api.model.Employee
import service.EmployeeServiceApi

class EmployeeServiceImpl (private val ktorClient: HttpClient): EmployeeServiceApi {
    override suspend fun addEmployee(employee: Employee): Employee? {
        return try {
            ktorClient.post(AppointmentsHttpRoutes.EMPLOYEES) {
                contentType(ContentType.Application.Json)
                setBody(employee)
            }.body<Employee>()
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

    override suspend fun updateEmployee(employee: Employee): Boolean {
        return try {
            ktorClient.put(AppointmentsHttpRoutes.EMPLOYEES) {
                contentType(ContentType.Application.Json)
                setBody(employee)
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

    override suspend fun getEmployee(id: Int): Employee? {
        return try {
            ktorClient.get("${AppointmentsHttpRoutes.EMPLOYEES}?") {
                parameter("id", id)
            }.body<Employee>()
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

    override suspend fun getAllEmployees(): List<Employee> {
        return try {
            ktorClient.get(AppointmentsHttpRoutes.EMPLOYEES).body<List<Employee>>()
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

    override suspend fun deleteEmployee(id: Int): Boolean {
        return try {
            ktorClient.delete("${AppointmentsHttpRoutes.EMPLOYEES}?") {
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