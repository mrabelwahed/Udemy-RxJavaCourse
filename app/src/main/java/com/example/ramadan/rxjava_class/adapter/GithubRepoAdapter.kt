package com.example.ramadan.rxjava_class.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ramadan.rxjava_class.R
import com.example.ramadan.rxjava_class.db.Repo
import kotlinx.android.synthetic.main.stars_item.view.*

class GithubRepoAdapter  : RecyclerView.Adapter<GithubRepoAdapter.StarRepoViewHolder>(){

     val data = ArrayList<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stars_item,parent,false)
        return StarRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: StarRepoViewHolder, position: Int) {
        viewHolder.repoName.text = data[position].name
        viewHolder.repoLang.text = data[position].lang
        viewHolder.repoStarsCount.text = data[position].starCount.toString()


        data[position].desc?.let{
            viewHolder.repoDesc.text = data[position].desc
        }?:run {
            viewHolder.repoDesc.text = "NO DESC"
        }
    }


    public fun addRepos(repos:ArrayList<Repo>){
        data.clear()
        data.addAll(repos)
        notifyDataSetChanged()
    }


    class StarRepoViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val repoName = view.repoName
        val repoDesc = view.desc
        val repoLang = view.lang
        val repoStarsCount = view.starsCount

    }
}