package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.dao.UserDao
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.entity.UserEntity

@Database(entities = [(UserEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}