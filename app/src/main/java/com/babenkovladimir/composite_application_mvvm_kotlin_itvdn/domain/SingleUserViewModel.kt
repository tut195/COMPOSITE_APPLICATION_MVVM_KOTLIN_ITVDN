package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.domain

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.widget.SingleLiveEvent
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.AppRepository
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.entity.UserEntity


class SingleUserViewModel(application: Application, private val mRepository: AppRepository) : BaseViewModel(application) {

    private val liveDataItem = SingleLiveEvent<UserEntity>()

    @SuppressLint("CheckResult")
    fun getItem(id: Int) {
        mRepository.getUser(id).subscribe { list -> liveDataItem.value = list }
    }

    fun getLiveDataItem(): LiveData<UserEntity> {
        return liveDataItem
    }
}