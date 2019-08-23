package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.component

import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.module.ApiModule
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.scope.ApiScope
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.server.ServerCommunicator
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}
