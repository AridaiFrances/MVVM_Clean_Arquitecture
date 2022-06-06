package com.musicaengijon.mvvm_clean_arquitecture.data.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Query("SELECT * FROM task_entity")
    fun getAllTasks(): MutableList<TaskEntity>

    @Insert
    fun addTask(taskEntity : TaskEntity):Long

//    @Query("SELECT * FROM task_entity where id like :arg0")
//    fun getTaskById(id: Long): TaskEntity

    @Update
    fun updateTask(taskEntity: TaskEntity):Int

    @Delete
    fun deleteTask(taskEntity: TaskEntity):Int
}