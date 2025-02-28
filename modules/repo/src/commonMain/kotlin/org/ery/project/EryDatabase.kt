package org.ery.project

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.ery.project.dao.AppointmentDao
import org.ery.project.dao.ClientDao
import org.ery.project.dao.EmployeeDao
import org.ery.project.dao.FacilityBookedDao
import org.ery.project.dao.FacilityDao
import org.ery.project.entity.AppointmentEntity
import org.ery.project.entity.ClientEntity
import org.ery.project.entity.EmployeeEntity
import org.ery.project.entity.FacilityBookedEntity
import org.ery.project.entity.FacilityEntity
import org.ery.project.model.AppointmentInfo

@Database(
    entities = [
        ClientEntity::class,
        AppointmentEntity::class,
        EmployeeEntity::class,
        FacilityBookedEntity::class,
        FacilityEntity::class
    ],
    views = [AppointmentInfo::class],
    version = 1
)
abstract class EryDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun appointmentDao(): AppointmentDao
    abstract fun employeeDao(): EmployeeDao
    abstract fun facilityDao(): FacilityDao
    abstract fun facilityBookedDao(): FacilityBookedDao

    companion object {
        fun getRoomDatabase(
            builder: Builder<EryDatabase>
        ): EryDatabase {
            return builder
                .addMigrations(*MIGRATIONS)
                .fallbackToDestructiveMigration(true)
                .setDriver(BundledSQLiteDriver())
                .setQueryCoroutineContext(Dispatchers.IO)
                .build()
        }

        private val MIGRATIONS: Array<Migration>
            get() = arrayOf()
    }
}