package com.example.android_homework.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("UsersEntity")
data class UsersEntity (
    @PrimaryKey(autoGenerate = false)

    @ColumnInfo("id")
    val id: Int?,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("username")
    val username: String,
    @ColumnInfo("e-mail")
    val email: String,
    @ColumnInfo("password")
    val password: String,
        )