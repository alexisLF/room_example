package com.example.foo.database

import androidx.room.*

@Dao
interface FooDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFoo(foo: Foo)

    @Query("SELECT * FROM foos WHERE id = :fooId")
    fun findFooById(fooId: String): Foo

    @Query("SELECT * FROM foos")
    fun getAllFoos(): List<Foo>

    @Update
    fun updateFooDetails(foo: Foo)

    @Delete
    fun deleteFoo(foo: Foo)
}