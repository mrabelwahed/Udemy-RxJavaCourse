package com.example.ramadan.rxjava_class.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull
import io.reactivex.annotations.Nullable


@Entity(tableName = "repo")
data class Repo (
                 @PrimaryKey
                 @ColumnInfo(name = "id")
                 @SerializedName("id")  val id:String,
                 @ColumnInfo(name = "name")
                 @SerializedName("name")  val name:String,
                 @ColumnInfo(name = "description")
                 @SerializedName("description") val desc:String?,
                 @ColumnInfo(name = "language")
                 @SerializedName("language") val lang:String?,
                 @ColumnInfo(name = "stargazers_count")
                 @SerializedName("stargazers_count") val starCount:Int
)