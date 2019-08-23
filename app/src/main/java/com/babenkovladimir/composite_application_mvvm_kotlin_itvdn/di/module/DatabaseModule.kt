package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module


import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val appDatabase: AppDatabase) {
    @Provides
    internal fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }
}