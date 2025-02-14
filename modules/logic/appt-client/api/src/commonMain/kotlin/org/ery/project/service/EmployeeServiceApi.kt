package service

import org.ery.project.appointments_client.api.model.Employee

interface EmployeeServiceApi {
    suspend fun addEmployee(employee: Employee): Employee?
    suspend fun updateEmployee(employee: Employee): Boolean
    suspend fun getEmployee(id: Int): Employee?
    suspend fun getAllEmployees(): List<Employee>
    suspend fun deleteEmployee(id: Int): Boolean
}