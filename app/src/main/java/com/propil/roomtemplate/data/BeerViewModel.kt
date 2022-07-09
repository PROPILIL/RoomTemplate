package com.propil.roomtemplate.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BeerViewModel(application: Application) : AndroidViewModel(application) {

    private val getAllBeer: LiveData<List<BeerModel>>
    private val repository: BeerRepository

    init {
        val beerDao = BeerDatabase.getDatabase(application).beerDao()
        repository = BeerRepository(beerDao)
        getAllBeer = repository.getAllBeer
    }

    fun addBeer(beer: BeerModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBeer(beer)
        }
    }

}