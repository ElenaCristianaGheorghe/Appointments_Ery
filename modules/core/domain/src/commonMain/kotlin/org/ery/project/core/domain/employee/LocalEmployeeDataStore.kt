package org.ery.project.core.domain.employee

import kotlinx.coroutines.flow.Flow
import org.ery.project.core.domain.model.Employee
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

interface LocalEmployeeDataStore {
    fun loadEmployee(): Flow<List<Employee>>
    suspend fun upsertEmployee(employee: Employee): Result<Long, DataError.Local>
    suspend fun deleteEmployee(employeeId: Long)
}