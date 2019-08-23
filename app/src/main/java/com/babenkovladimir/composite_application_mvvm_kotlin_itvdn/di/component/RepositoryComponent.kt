package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.component

import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.RepositoryModule
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.scope.RepositoryScope
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.AppRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repository: AppRepository
}