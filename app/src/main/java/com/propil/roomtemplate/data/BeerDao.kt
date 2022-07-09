package com.propil.roomtemplate.data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BeerDao {

    // insert one beer
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBeer(beer: BeerModel)

    @Query("SELECT * FROM beerdatabase ORDER BY id ASC")
    fun getAllBeer(): LiveData<List<BeerModel>>
}