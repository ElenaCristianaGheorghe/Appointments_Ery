package org.ery.project.core.domain.employee

import kotlinx.coroutines.flow.Flow
import org.ery.project.core.domain.model.Employee
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult

interface EmployeeRepository {
    fun loadEmployees(): Flow<List<Employee>>
    suspend fun fetchEmployees(): EmptyResult<DataError>
    suspend fun upsertEmployee(): EmptyResult<DataError>
    suspend fun deleteEmployee(employeeId: Long)
}