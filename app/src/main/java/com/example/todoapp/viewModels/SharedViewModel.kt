package com.example.todoapp.viewModels

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    fun parsPriority(priority: String): Priority {
        return when (priority) {
            "High" -> Priority.HIGH
            "Medium" -> Priority.MEDIUM
            "Low" -> Priority.LOW
            else -> Priority.LOW
        }
    }

        val listner: AdapterView.OnItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> (parent?.getChildAt(0) as TextView)
                        .setTextColor(ContextCompat.getColor(application, R.color.red))
                    1 -> (parent?.getChildAt(0) as TextView)
                        .setTextColor(ContextCompat.getColor(application, R.color.green))
                    2 -> (parent?.getChildAt(0) as TextView)
                        .setTextColor(ContextCompat.getColor(application, R.color.blue))
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

   fun parsPriority(priority: Priority): Int {
        return when(priority){
            Priority.HIGH -> 0
            Priority.MEDIUM -> 1
            Priority.LOW -> 2
        }
    }
}