package org.d3if2085.perhitungan.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if2085.perhitungan.database.entity.Perhitungan
import org.d3if2085.perhitungan.repository.PerhitunganRepository

class PerhitunganViewModel(private val repository: PerhitunganRepository) : ViewModel() {
    var gertAllPerhitungan: LiveData<List<Perhitungan>> = repository.getAllPerhitungan()
    fun insertPerhitungan(perhitungan: Perhitungan) =viewModelScope.launch(Dispatchers.IO){
        repository.insertPerhitungan(perhitungan)

    }

    fun deleteHistory(perhitungan: Perhitungan)= viewModelScope.launch(Dispatchers.IO) {
        repository.deleteHistory(perhitungan)
    }
}