package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.item

interface IUserItemClickListener<M> {
    fun openDetail(m: M)
}