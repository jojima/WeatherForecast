package com.example.fabiojojima.retrofitapp.weather

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import org.joda.time.DateTime

@Entity(tableName = "city_table")
class City (var name: String = "",
            var country: String = "",
            var list: List<Forecast>,
//            var lastUpdatedDate : DateTime = DateTime(),
            @NonNull @PrimaryKey @ColumnInfo(name = "id") var id: Int = 0)