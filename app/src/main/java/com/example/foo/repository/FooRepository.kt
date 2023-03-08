package com.example.foo.repository

import com.example.foo.database.Foo
import com.example.foo.database.FooDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FooRepository(private val fooDao: FooDao) {

    var allFoos = ArrayList<Foo>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addFoo(newFoo: Foo) {
        coroutineScope.launch(Dispatchers.IO) {
            fooDao.addFoo(newFoo)
        }
    }

    fun updateFooDetails(newFoo: Foo) {
        coroutineScope.launch(Dispatchers.IO) {
            fooDao.updateFooDetails(newFoo)
        }
    }

    fun getAllFoos() {
        coroutineScope.launch(Dispatchers.IO) {
            allFoos = ArrayList<Foo>()
            val fooList = fooDao.getAllFoos()
            println(fooList)
            allFoos.addAll(fooList)
        }
    }

    fun deleteFoo(foo: Foo) {
        coroutineScope.launch(Dispatchers.IO) {
            fooDao.deleteFoo(foo)
        }
    }


}