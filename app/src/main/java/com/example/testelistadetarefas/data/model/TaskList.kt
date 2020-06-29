package com.example.testelistadetarefas.data.model

import org.json.JSONArray

class TaskList {

    var title = ""
    var email = ""
    var description = ""

    override fun toString(): String {
        return "Dev(title='$title', email='$email', description='$description')"
    }
}
