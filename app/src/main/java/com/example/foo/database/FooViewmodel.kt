package com.example.foo.database

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.foo.repository.FooRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FoosViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application.applicationContext,
        AppDatabase::class.java,
        "db-foos"
    ).build()

    private val repo:FooRepository = FooRepository(db.fooDao())

    var foos by mutableStateOf(listOf<Foo>())
        private set

    // Load initial data from Room asynchronously.
    init {
        GlobalScope.launch {
            val items = db.fooDao().getAllFoos()
            viewModelScope.launch { foos = items }
        }
    }

    fun addFoo(code:String, libelle: String) {
        val fooObj = Foo(id= 0, code = code, libelle = libelle)
        foos = foos + listOf(fooObj)
        GlobalScope.launch { repo.addFoo(fooObj) }
    }

    fun removeFoo(foo: Foo) {
        foos = foos - listOf(foo)
        GlobalScope.launch { repo.deleteFoo(foo) }
    }

    fun getAll() {
        GlobalScope.launch {
            repo.getAllFoos()
        }
    }

}