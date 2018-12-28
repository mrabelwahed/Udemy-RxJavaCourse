package com.example.ramadan.rxjava_class.repository

import com.example.ramadan.rxjava_class.db.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoRepository(val repoRemoteSource: RepoRemoteSource, val repoLocalSource: RepoLocalSource) : RepoDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {

        return Observable.concat(repoLocalSource.fetchRepos(username),
                repoRemoteSource.fetchRepos(username)
                        .doOnNext { it -> saveRepos(it) }
                        .onErrorResumeNext(Observable.empty())

        )

    }

    override fun saveRepos(repos: List<Repo>) {
        repoLocalSource.saveRepos(repos)

    }

}