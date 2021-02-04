package com.example.todoapp

import androidx.room.TypeConverter
import com.example.todoapp.data.models.Priority

class TodoUtils {
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}