package com.example.todoapp.data

import android.content.Context
import androidx.room.*
import com.example.todoapp.TodoUtils
import com.example.todoapp.data.models.TodoData

@Database(entities = [TodoData::class], version = 1, exportSchema = false)
@TypeConverters(TodoUtils::class)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao

    companion object {
        private var INSTANCE: TodoDatabase? = null
        fun getInstance(context: Context): TodoDatabase {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    TodoDatabase::class.java,
                    "todoDatabase"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
            }
            return instance
        }
    }
}
