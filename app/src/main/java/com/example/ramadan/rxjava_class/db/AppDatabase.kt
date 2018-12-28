package com.example.ramadan.rxjava_class.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.content.Context


@Database(entities = arrayOf(Repo::class) , version = 2)
abstract  class AppDatabase  : RoomDatabase(){
    abstract fun getRepoDao() :RepoDAO

    companion object {
        var INSTANCE :AppDatabase? = null

        fun getInstance(context:Context):AppDatabase?{
            INSTANCE?.let { INSTANCE }?:run {
                INSTANCE = Room.databaseBuilder(context,AppDatabase::class.java,"repo.db").build()
            }

           return INSTANCE
        }
    }

}