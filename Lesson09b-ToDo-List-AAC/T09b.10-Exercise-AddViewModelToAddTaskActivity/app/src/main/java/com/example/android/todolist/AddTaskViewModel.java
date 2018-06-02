package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

// COMPLETED (5) Make this class extend ViewModel
public class AddTaskViewModel extends ViewModel {

    public LiveData<TaskEntry> getTask() {
        return task;
    }

    private LiveData<TaskEntry> task;
    public AddTaskViewModel(AppDatabase mDb, int mTaskId) {
        task = mDb.taskDao().loadTaskById(mTaskId);
    }

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId

    // COMPLETED (7) Create a getter for the task variable
}
