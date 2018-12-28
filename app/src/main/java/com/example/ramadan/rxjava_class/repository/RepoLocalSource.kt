package com.example.ramadan.rxjava_class.repository

import android.arch.persistence.room.Room
import com.example.ramadan.rxjava_class.RxApp
import com.example.ramadan.rxjava_class.db.AppDatabase
import com.example.ramadan.rxjava_class.db.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RepoLocalSource :RepoDataSource{

    override fun fetchRepos(username: String): Observable<List<Repo>> {

        return Observable.fromCallable {
            AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.fetchAllMyStarsRepos()
        }

    }

    override fun saveRepos(repos: List<Repo>) {
        AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllMyStarsRepos(repos)
    }

}