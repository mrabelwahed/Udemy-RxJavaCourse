package com.example.ramadan.rxjava_class.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface RepoDAO {

    @Query(" SELECT * FROM repo")
    fun fetchAllMyStarsRepos(): List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMyStarsRepos(repos: List<Repo>)

}