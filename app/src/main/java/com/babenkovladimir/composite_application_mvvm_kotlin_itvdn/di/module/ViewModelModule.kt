package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module

import android.app.Application
import com.babenkovladimir.App
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.scope.ViewModelScope
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.domain.AllUsersViewModel
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.domain.SingleUserViewModel
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.AppRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesAllUserViewModel(repository: AppRepository): AllUsersViewModel {
        return AllUsersViewModel(app, repository)
    }

    @ViewModelScope
    @Provides
    internal fun providesSingleUserViewModel(repository: AppRepository): SingleUserViewModel {
        return SingleUserViewModel(app, repository)
    }
}