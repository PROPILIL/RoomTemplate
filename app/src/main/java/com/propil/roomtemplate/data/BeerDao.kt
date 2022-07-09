package com.propil.roomtemplate.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface BeerDao {

    // insert one beer
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBeer(beer: BeerModel)

    @Query("SELECT * FROM beerdatabase ORDER BY id ASC")
    fun getAllBeer(): LiveData<List<BeerModel>>
}