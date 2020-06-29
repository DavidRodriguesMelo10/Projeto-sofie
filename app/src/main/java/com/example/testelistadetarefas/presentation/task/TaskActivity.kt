package com.example.testelistadetarefas.presentation.task


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.testelistadetarefas.R
import com.example.testelistadetarefas.data.model.Res
import com.example.testelistadetarefas.data.model.Task
import kotlinx.android.synthetic.main.activity_task.*

class TaskActivity : AppCompatActivity() {

    private val dataList: MutableList<Task> = mutableListOf()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val btnAdd = findViewById<Button>(R.id.btn_add)

        btnAdd.setOnClickListener {
            val telaCadastro = Intent (this, TarefasActivity::class.java)
            startActivity(telaCadastro)
        }

        toolbarMain.title = "Sofie"
        setSupportActionBar(toolbarMain)



        adapter = TaskAdapter(dataList)

        //SETUP RECYCLEVIEW
        recyclerTask.layoutManager = LinearLayoutManager (this)
        recyclerTask.addItemDecoration(DividerItemDecoration (this, OrientationHelper.VERTICAL))
        recyclerTask.adapter = adapter


        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/beta/task")
                .build()
                .getAsObject(Res::class.java, object : ParsedRequestListener<Res> {
                    override fun onResponse(response: Res) {
                        dataList.addAll(response.data)
                        adapter.notifyDataSetChanged()

                    }

                    override fun onError(anError: ANError?) {
                    }
                })
    }
}