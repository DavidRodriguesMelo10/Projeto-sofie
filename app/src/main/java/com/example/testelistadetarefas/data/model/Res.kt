package com.example.testelistadetarefas.data.model

import com.google.gson.annotations.SerializedName


data class Res (

    @SerializedName("data")
    val `data`: List<Task>
)
