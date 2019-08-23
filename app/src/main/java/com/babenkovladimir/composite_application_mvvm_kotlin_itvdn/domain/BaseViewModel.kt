package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.domain

import android.app.Application

import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import com.babenkovladimir.App


abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    fun getContext() = getApplication<App>()
    fun getString(@StringRes id: Int): String = getContext().getString(id)
}