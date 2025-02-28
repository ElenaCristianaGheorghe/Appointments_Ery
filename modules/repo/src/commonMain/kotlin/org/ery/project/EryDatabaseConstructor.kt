package org.ery.project

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object EryDatabaseConstructor : RoomDatabaseConstructor<EryDatabase> {
    override fun initialize(): EryDatabase
}