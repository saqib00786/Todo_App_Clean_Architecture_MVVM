package com.example.todoapp

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.room.TypeConverter
import com.example.todoapp.data.models.Priority
import com.example.todoapp.ui.adapter.TodoAdapter

class TodoUtils() {
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }


}