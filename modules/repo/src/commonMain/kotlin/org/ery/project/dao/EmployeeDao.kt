package org.ery.project.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.ery.project.model.Employee

@Dao
interface EmployeeDao {
    @Upsert
    suspend fun insertEmployee(clients: List<Employee>)

    @Query("SELECT * FROM employees")
    suspend fun getAllClients(): List<Employee>

    @Query("SELECT * FROM employees WHERE is_synced = 0")
    suspend fun getUnsyncedEmployees(): List<Employee> // Fetch local changes

    @Query("UPDATE employees SET is_synced = 1 WHERE id IN (:employeeIds)")
    suspend fun markEmployeesAsSynced(employeeIds: List<Int>)

    @Query("DELETE FROM employees WHERE id NOT IN (:employeeIds)")
    suspend fun deleteEmployeesNotIn(employeeIds: List<Int>)
}