package com.example.popayan.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "El Servicio Nacional de Aprendizaje (SENA) es un establecimiento público de educación en Colombia que ofrece formación gratuita con programas técnicos, tecnológicos y complementarios. Está adscrito al Ministerio del Trabajo de Colombia y goza de autonomía administrativa.\u200B\n" +
                "\n" +
                "La oferta regular para formación profesional: técnicos, tecnólogos y trabajadores especializados incluye más de 522 programas"
    }
    val text: LiveData<String> = _text
}