package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.R
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.base.BaseAdapter
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.item.IUserItemClickListener
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.item.UserViewHolder
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.entity.UserEntity


class UserAdapter(
    private val context: Context,
    private val users: List<UserEntity>,
    private val listener: IUserItemClickListener<UserEntity>
) :
    BaseAdapter<UserViewHolder, UserEntity, IUserItemClickListener<UserEntity>>(
        users as MutableList<UserEntity>,
        listener
    ) {

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(userViewHolder: UserViewHolder, i: Int) {
        super.onBindViewHolder(userViewHolder, i)
        userViewHolder.bind(users[i], listener)
    }
}
