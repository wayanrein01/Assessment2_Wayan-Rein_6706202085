package org.d3if2085.perhitungan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if2085.perhitungan.database.dao.PerhitunganDao
import org.d3if2085.perhitungan.database.entity.Perhitungan

@Database(
    entities = [
 Perhitungan::class
    ],
    version = 1,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase() {

    abstract val perhitunganDao :PerhitunganDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDB::class.java,
                        "tes.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}