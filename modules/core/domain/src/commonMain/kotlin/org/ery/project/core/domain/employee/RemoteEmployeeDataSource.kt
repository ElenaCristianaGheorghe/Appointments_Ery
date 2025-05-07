package org.ery.project.core.domain.employee

import org.ery.project.core.domain.model.Employee
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.EmptyResult
import org.ery.project.core.domain.util.Result

interface RemoteEmployeeDataSource {
    suspend fun getEmployees(): Result<List<Employee>, DataError.Network>
    suspend fun postEmployee(employee: Employee): Result<Employee, DataError.Network>
    suspend fun deleteEmployee(employeeId: Long): EmptyResult<DataError.Network>
}