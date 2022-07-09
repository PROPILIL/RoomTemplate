package com.propil.roomtemplate.data

import androidx.lifecycle.LiveData

class BeerRepository(private val beerDao: BeerDao) {

    val getAllBeer: LiveData<List<BeerModel>> = beerDao.getAllBeer()

    suspend fun addBeer(beer: BeerModel) {
        beerDao.addBeer(beer)
    }

}