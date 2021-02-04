package com.example.todoapp.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.data.TodoDao
import com.example.todoapp.data.models.TodoData

class TodoRepository(private val todoDao: TodoDao) {
    val getAllData: LiveData<List<TodoData>> = todoDao.getAllData()
    suspend fun insertDataRepository(todoData: TodoData) {
        todoDao.insertData(todoData)
    }

    /*suspend fun deleteDataRepository(todoData: TodoData) {
        todoDao.deleteDataItem(todoData)
    }

    suspend fun updateDataRepository(todoData: TodoData) {
        todoDao.updateData(todoData)
    }*/
}