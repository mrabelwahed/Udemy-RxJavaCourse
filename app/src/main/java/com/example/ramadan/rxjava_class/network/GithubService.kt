package com.example.ramadan.rxjava_class.network

import com.example.ramadan.rxjava_class.db.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/starred")
    fun getStarredRepos(@Path("user") username:String): Observable<List<Repo>>
}