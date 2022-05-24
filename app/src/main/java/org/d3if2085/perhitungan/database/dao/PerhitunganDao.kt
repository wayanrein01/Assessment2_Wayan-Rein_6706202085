package org.d3if2085.perhitungan.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.d3if2085.perhitungan.database.entity.Perhitungan

@Dao
interface PerhitunganDao {
 @Insert
    suspend fun insertPerhitungan(perhitungan: Perhitungan)

    @Query("SELECT * FROM tbl_perhitungan")
    fun  getAllPerhitungan(): LiveData<List<Perhitungan>>

    @Delete
    suspend fun deleteHistory(perhitungan: Perhitungan)
}