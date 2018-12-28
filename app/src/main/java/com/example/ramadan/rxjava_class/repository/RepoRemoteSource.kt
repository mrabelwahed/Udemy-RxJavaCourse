package com.example.ramadan.rxjava_class.repository

import com.example.ramadan.rxjava_class.db.Repo
import com.example.ramadan.rxjava_class.network.GithubApiClient
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

object RepoRemoteSource : RepoDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return GithubApiClient.getGithubSerivce().getStarredRepos(username)
    }

    override fun saveRepos(repos: List<Repo>) {
    }
}