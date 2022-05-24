package org.d3if2085.perhitungan.viemodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2085.perhitungan.repository.PerhitunganRepository

class PerhitunganViewModelFactory (val repository: PerhitunganRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PerhitunganViewModel::class.java)){
            return PerhitunganViewModel(repository)as T
        }
        throw IllegalArgumentException("view model tidak di temukan")
    }
}