package com.example.data.db.entities

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class Mappers {
    @TypeConverter
    fun fromString(value: String): List<MovementEntity> {
        val listType = object : TypeToken<List<MovementEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<MovementEntity>): String {
        return Gson().toJson(list)
    }
}