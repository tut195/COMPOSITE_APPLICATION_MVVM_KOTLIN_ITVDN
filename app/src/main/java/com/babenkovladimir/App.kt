package com.babenkovladimir

import android.app.Application
import androidx.room.Room
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.component.*
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.AppDatabase
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.ApiModule
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.DatabaseModule
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.RepositoryModule
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.ViewModelModule


class App: Application() {

    private var viewModelComponent: ViewModelComponent? = null
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this!!.database!!))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .repositoryComponent(repositoryComponent)
            .viewModelModule(ViewModelModule(this))
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this!!.viewModelComponent!!
    }
}