package org.ery.project.core.database.datasource

import androidx.sqlite.SQLiteException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.ery.project.core.database.dao.EmployeeDao
import org.ery.project.core.database.mappers.toEmployee
import org.ery.project.core.database.mappers.toEmployeeEntity
import org.ery.project.core.domain.employee.LocalEmployeeDataStore
import org.ery.project.core.domain.model.Employee
import org.ery.project.core.domain.util.DataError
import org.ery.project.core.domain.util.Result

class RoomLocalEmployeeDataSource(
    private val employeeDao: EmployeeDao
): LocalEmployeeDataStore {
    override fun loadEmployee(): Flow<List<Employee>> {
        return employeeDao.loadEmployees().map { employees ->
            employees.map { it.toEmployee() }
        }
    }

    override suspend fun upsertEmployee(employee: Employee): Result<Long, DataError.Local> {
        return try {
            val entity = employee.toEmployeeEntity()
            val id = employeeDao.upsertEmployee(entity)
            Result.Success(id)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteEmployee(employeeId: Long) {
        employeeDao.deleteEmployee(employeeId)
    }
}