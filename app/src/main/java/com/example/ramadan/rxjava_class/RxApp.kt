package com.example.ramadan.rxjava_class

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.ramadan.rxjava_class.db.AppDatabase
import com.example.ramadan.rxjava_class.db.RepoDAO

class RxApp :Application() {
    companion object {
        lateinit var  inst :RxApp
        fun getInstance():RxApp{
            return inst
        }
    }

    lateinit var db:AppDatabase

    override fun onCreate() {
        super.onCreate()
        inst = this
      // db = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"repo-db").build()
    }

//    fun getDB():AppDatabase{
//        return db
//    }


}