package org.ery.project.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.ery.project.core.database.entity.EmployeeEntity

@Dao
interface EmployeeDao {
    @Upsert
    suspend fun upsertEmployee(employee: EmployeeEntity): Long

    @Query("SELECT * FROM employees")
    fun loadEmployees(): Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM employees")
    fun getEmployees(): List<EmployeeEntity>

    @Query("DELETE FROM employees WHERE id = :id")
    suspend fun deleteEmployee(id: Long)
}