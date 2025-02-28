package org.ery.project

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<EryDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("ery.db")
    return Room.databaseBuilder<EryDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}