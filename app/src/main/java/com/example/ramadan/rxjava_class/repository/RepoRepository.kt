package com.example.ramadan.rxjava_class.repository

import com.example.ramadan.rxjava_class.db.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoRepository (val repoRemoteSource: RepoRemoteSource, val repoLocalSource:RepoLocalSource) :RepoDataSource {
    override fun fetchRepos(username: String): Flowable<List<Repo>> {
       return  Flowable.concat(
                repoLocalSource.fetchRepos(username),
                repoRemoteSource.fetchRepos(username)
                        .doOnNext{ repos -> saveRepos(repos)}
                        .onErrorResumeNext(Flowable.empty())
       )


    }

    override fun saveRepos(repos: List<Repo>) {
        repoLocalSource.saveRepos(repos)

    }

}