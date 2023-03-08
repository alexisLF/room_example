package com.example.foo.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foos")
data class Foo (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "code")
    var code: String,

    @ColumnInfo(name = "label")
    var libelle: String,

)