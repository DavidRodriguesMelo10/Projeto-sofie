package com.example.testelistadetarefas.presentation.task

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.testelistadetarefas.Network.HttpHelper
import com.example.testelistadetarefas.R
import com.example.testelistadetarefas.data.model.TaskList
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_new_task.*
import org.jetbrains.anko.doAsync

class TaskNew : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        val buttonSave = findViewById<Button>(R.id.btn_save)
        val editTextEmail = findViewById<EditText>(R.id.edit_text_email)
        val editTextTarefa = findViewById<EditText>(R.id.edit_text_tarefa)
        val editTextDescription = findViewById<EditText>(R.id.edit_text_description)

        buttonSave.setOnClickListener{
            //criar objeto
            val tarefa = TaskList()
            tarefa.email = editTextEmail.text.toString()
            tarefa.title = editTextTarefa.text.toString()
            tarefa.description = editTextDescription.text.toString()

            //covert tarefa para formato json
            val gson = Gson()
            val tarefaJson = gson.toJson(tarefa)

            btn_save.setOnClickListener{

                Toast.makeText(this, "Enviado com sucesso" + btn_save.tag,Toast.LENGTH_LONG).show()
                closeContextMenu()
            }



            doAsync {
                val http = HttpHelper()
                http.post(tarefaJson)
            }

        }

    }
}