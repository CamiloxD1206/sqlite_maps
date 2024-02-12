package com.example.popayan.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "El Morro del Tulcán o Pirámide de Tucán es el principal sitio arqueológico de Popayán. Este consiste en una pequeña loma no natural en forma de pirámide truncada, en la cual se encontraron elementos de la época precolombina, aproximadamente entre los años 500 – 1600 a."
    }
    val text: LiveData<String> = _text
}