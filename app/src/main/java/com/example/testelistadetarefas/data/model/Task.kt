package com.example.testelistadetarefas.data.model

import com.google.gson.annotations.SerializedName

data class Task(

        @SerializedName("description")
        val description: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("_id")
        val id: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("when")
        val whenX: String
)