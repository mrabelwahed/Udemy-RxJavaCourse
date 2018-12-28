package com.example.ramadan.rxjava_class.repository

import com.example.ramadan.rxjava_class.db.Repo
import io.reactivex.Flowable
import io.reactivex.Observable

interface RepoDataSource {
    fun fetchRepos(username:String) : Observable<List<Repo>>
    fun saveRepos(repos :List<Repo>)
}