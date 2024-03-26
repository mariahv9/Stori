package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.db.dao.HomeDAO
import com.example.data.db.dao.LoginDAO
import com.example.data.db.dao.RegisterDAO
import com.example.data.db.entities.Mappers
import com.example.data.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 3)
@TypeConverters(Mappers::class)
abstract class RoomDB : RoomDatabase() {
    abstract fun loginDao(): LoginDAO
    abstract fun registerDao(): RegisterDAO
    abstract fun homeDao(): HomeDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(
            context: Context
        ): RoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "room_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                instance
            }
        }
    }
}
