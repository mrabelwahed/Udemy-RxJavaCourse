package com.example.ramadan.rxjava_class

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.ramadan.rxjava_class.db.AppDatabase
import com.example.ramadan.rxjava_class.db.RepoDAO

class RxApp :Application() {
    companion object {
        lateinit var  INSTANCE:RxApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }




}