package org.d3if2085.perhitungan.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import org.d3if2085.perhitungan.database.dao.PerhitunganDao
import org.d3if2085.perhitungan.database.entity.Perhitungan

class PerhitunganRepository(val dao: PerhitunganDao) {

    suspend fun insertPerhitungan(perhitungan: Perhitungan){
        dao.insertPerhitungan(perhitungan)
    }

    suspend fun deleteHistory(perhitungan: Perhitungan){
        dao.deleteHistory(perhitungan)
    }
    fun  getAllPerhitungan(): LiveData<List<Perhitungan>> = dao.getAllPerhitungan()

}