package com.propil.roomtemplate.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BeerModel::class], version = 1, exportSchema = false)
abstract class BeerDatabase: RoomDatabase() {

    abstract fun beerDao(): BeerDao

    companion object {
        @Volatile
        private var INSTANCE: BeerDatabase? = null


        // инициализации базы данных в контекст (добавлю потом в Application.OnCreate)
        // UPDATE: добавил во BeerViewModel, т.к. она имеет экземпляр Application
        fun getDatabase(context: Context): BeerDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BeerDatabase::class.java,
                    "BeerDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}