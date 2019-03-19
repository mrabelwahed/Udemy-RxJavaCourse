package com.example.ramadan.rxjava_class.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.ramadan.rxjava_class.db.Repo
import com.example.ramadan.rxjava_class.network.GithubApiClient
import com.example.ramadan.rxjava_class.repository.RepoLocalSource
import com.example.ramadan.rxjava_class.repository.RepoRemoteSource
import com.example.ramadan.rxjava_class.repository.RepoRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    val repoLiveData = MutableLiveData<List<Repo>>()
    val repository = RepoRepository(RepoRemoteSource , RepoLocalSource)


    fun getMyStarsRepos(username:String){
        if (repoLiveData.value !=null){
            return
        }
       val reposDisposable = repository.fetchRepos(username)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe{it-> repoLiveData.value = it}


        compositeDisposable.add(reposDisposable)

    }


    fun getLiveData():LiveData<List<Repo>> = repoLiveData


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}