package org.d3if2085.perhitungan.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_perhitungan")
data class Perhitungan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val hasil: Float,
    val jenis: String,
    val angka1: Float,
    val angka2: Float

)

