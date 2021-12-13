package com.musicaengijon.mvvm_clean_arquitecture.ui.room

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.musicaengijon.mvvm_clean_arquitecture.MvvmCleanArquitecture
import com.musicaengijon.mvvm_clean_arquitecture.R
import com.musicaengijon.mvvm_clean_arquitecture.data.cache.TaskEntity
import com.musicaengijon.mvvm_clean_arquitecture.databinding.ActivityRoomBinding
import com.musicaengijon.mvvm_clean_arquitecture.ui.maps.MapsActivity
import kotlinx.android.synthetic.main.activity_room.btnAddTask
import kotlinx.android.synthetic.main.activity_room.etTask
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class RoomActivity : AppCompatActivity() {

    companion object {

        fun getCallingIntent(context: Context): Intent {
            return Intent(context, RoomActivity::class.java)
        }
    }

    private lateinit var binding: ActivityRoomBinding
    private val roomViewModel: RoomViewModel by viewModels()
    private lateinit var adapter: TasksAdapter

    lateinit var recyclerView: RecyclerView
    lateinit var tasks: MutableList<TaskEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tasks = ArrayList()
        getTasks()

        binding.btnAddTask.setOnClickListener {
            addTask(TaskEntity(name = etTask.text.toString()))}
    }

    private fun getTasks() {
        doAsync {
            tasks = MvvmCleanArquitecture.database.taskDao().getAllTasks()
            uiThread {
                setUpRecyclerView(tasks)
            }
        }
    }

    private fun setUpRecyclerView(tasks: List<TaskEntity>) {
        adapter = TasksAdapter(tasks, { updateTask(it) }, {deleteTask(it)})
        recyclerView = findViewById(R.id.rvTask)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun addTask(task:TaskEntity){
        doAsync {
            val id = MvvmCleanArquitecture.database.taskDao().addTask(task)
//            val recoveryTask = MvvmCleanArquitecture.database.taskDao().getTaskById(id)
            uiThread {
//                tasks.add(recoveryTask)
                adapter.notifyItemInserted(tasks.size)
                clearFocus()
                hideKeyboard()
            }
        }
    }

    private fun updateTask(task: TaskEntity) {
        doAsync {
            task.isDone = !task.isDone
            MvvmCleanArquitecture.database.taskDao().updateTask(task)
        }
    }

    private fun deleteTask(task: TaskEntity){
        doAsync {
            val position = tasks.indexOf(task)
            MvvmCleanArquitecture.database.taskDao().deleteTask(task)
            tasks.remove(task)
            uiThread {
                adapter.notifyItemRemoved(position)
            }
        }
    }

    private fun clearFocus(){
        binding.etTask.setText("")
    }
    private fun Context.hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }


}
