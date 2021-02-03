package com.example.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapp.data.models.TodoData

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData():LiveData<List<TodoData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(todoDao: TodoDao)

    @Update
    suspend fun updateData(todoDao: TodoDao)

    @Delete
    suspend fun deleteDataItem(todoDao: TodoDao)

    @Query("SELECT * FROM todo_table")
    suspend fun deleteAll()
}