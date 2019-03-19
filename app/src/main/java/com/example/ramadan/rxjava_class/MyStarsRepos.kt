package com.example.ramadan.rxjava_class

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.ramadan.rxjava_class.adapter.GithubRepoAdapter
import com.example.ramadan.rxjava_class.db.Repo
import com.example.ramadan.rxjava_class.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.activity_my_stars_repos.*

class MyStarsRepos : AppCompatActivity() {

    val repoList = ArrayList<Repo>()
    private lateinit var repoAdapter :GithubRepoAdapter
    private lateinit var repoViewModel :RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_stars_repos)


        val linearLayoutmg = LinearLayoutManager(applicationContext)
        val divider = DividerItemDecoration(myStarsList.context,DividerItemDecoration.VERTICAL)
        myStarsList.layoutManager = linearLayoutmg
        repoAdapter = GithubRepoAdapter()
        myStarsList.adapter = repoAdapter
        myStarsList.addItemDecoration(divider)

        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)



        getStarredRepos(repoViewModel)

        observeMyStars(repoViewModel)

    }


    fun getStarredRepos(viewModel :RepoViewModel){
        viewModel.getMyStarsRepos("mrabelwahed")
    }

    fun observeMyStars(viewModel:RepoViewModel){
        viewModel.getLiveData().observe(this, Observer {
            repos -> repoAdapter.addRepos(ArrayList(repos))
        })
    }
}
