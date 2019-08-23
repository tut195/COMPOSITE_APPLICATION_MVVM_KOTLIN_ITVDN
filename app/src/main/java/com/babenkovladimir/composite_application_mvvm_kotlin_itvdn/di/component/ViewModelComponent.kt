package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.component

import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.ViewModelModule
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.scope.ViewModelScope
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.activities.detail.DetailActivity
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.activities.main.MainActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [RepositoryComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: DetailActivity)
}