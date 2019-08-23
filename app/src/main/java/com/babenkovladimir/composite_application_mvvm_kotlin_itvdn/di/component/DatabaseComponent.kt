package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.component

import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.DatabaseModule
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.AppDatabase
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}
