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

    fun parsPriority(priority: String) : Priority{
        return when(priority){
            "High" -> Priority.HIGH
            "Medium" -> Priority.MEDIUM
            "Low" -> Priority.LOW
            else -> Priority.LOW
        }
    }
}