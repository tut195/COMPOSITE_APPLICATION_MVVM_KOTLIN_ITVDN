package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.domain

import android.annotation.SuppressLint
import android.app.Application

import androidx.lifecycle.LiveData
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.widget.SingleLiveEvent
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.AppRepository
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.entity.UserEntity



class AllUsersViewModel(application: Application, private val mRepository: AppRepository) : BaseViewModel(application) {
    private val liveDataItems = SingleLiveEvent<List<UserEntity>>()

    @SuppressLint("CheckResult")
    fun getAllItems() {
        mRepository.getAll()?.subscribe { list -> liveDataItems.value = list }
    }

    fun getLiveDataItems(): LiveData<List<UserEntity>> {
        return liveDataItems
    }
}

