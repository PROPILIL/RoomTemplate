package com.propil.roomtemplate.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BeerDatabase")
data class BeerModel(@PrimaryKey(autoGenerate = true) var id: Long = 0,

                     @ColumnInfo(name = "Beer brand")
                     var beerBrand: String = "",

                     @ColumnInfo(name = "Beer Description")
                     var beerDescription: String = "",

                     @ColumnInfo(name = "Beer sort")
                     var beerSort: String = "",

                     @ColumnInfo(name = "Sort version")
                     var sortVersion: String = "",

                     @ColumnInfo(name = "Beer Volume")
                     var beerVolume: Double = 0.0,

                     @ColumnInfo(name = "Beer Image")
                     var beerImageResId: Int = 0
)