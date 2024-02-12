package com.example.popayan.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "El Parque Caldas es la plaza principal de la ciudad de Popayán, Colombia. Se encuentra ubicado en el Centro Histórico de la Ciudad, lugar donde convergen todos los edificios principales y representativos de la ciudad. Desde el año 2010 Con una inversión de más de 2.300 millones de pesos financiados por FONADE y con el aporte de 550 millones de la Alcaldía de Popayán, se entregaron las obras de ampliación, ornato y embellecimiento del área peatonal del parque.\u200B"
    }
    val text: LiveData<String> = _text
}