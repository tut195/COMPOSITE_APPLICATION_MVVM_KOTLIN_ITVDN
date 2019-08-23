package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module

import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.scope.RepositoryScope
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.AppRepository
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.AppDatabase
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesRepository(communicator: ServerCommunicator, database: AppDatabase): AppRepository {
        return AppRepository(communicator, database)
    }
}