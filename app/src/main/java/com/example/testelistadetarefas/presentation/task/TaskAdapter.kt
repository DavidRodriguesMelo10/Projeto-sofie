package com.example.testelistadetarefas.presentation.task

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testelistadetarefas.R
import com.example.testelistadetarefas.R.*
import com.example.testelistadetarefas.data.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(private val dataList: MutableList<Task>) : RecyclerView.Adapter<TaskViewModel>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewModel {
        context = parent.context
        return  TaskViewModel(LayoutInflater.from(context).inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: TaskViewModel, position: Int) {
        val data = dataList[position]

        val tarefaNameTextView = holder.itemView.TextTitle
        val emailNameTextView = holder.itemView.TextEmail

        val tarefaName = "${data.title}"
        tarefaNameTextView.text = tarefaName

        val email = "${data.email}"
        emailNameTextView.text = email


        holder.itemView.setOnClickListener {
            Toast.makeText(context, tarefaName, Toast.LENGTH_SHORT).show()
            Toast.makeText(context, email, Toast.LENGTH_SHORT).show()
        }
    }
}
