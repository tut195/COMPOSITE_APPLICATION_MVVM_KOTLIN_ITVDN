package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.activities.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.R
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.component.ViewModelComponent
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.domain.AllUsersViewModel
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.activities.detail.DetailActivity
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.adapter.UserAdapter
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.base.BaseActivity
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.item.IUserItemClickListener
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.entity.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject

class MainActivity : BaseActivity() {

    var viewModel: AllUsersViewModel? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel?.getAllItems()
        viewModel?.getLiveDataItems()?.observe(this, Observer { it?.let { initRecyclerView(it) } })
    }

    private fun initRecyclerView(users: List<UserEntity>) {
        val manager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(this, users, itemClickListener)
        userAdapter.setItemClickListener(itemClickListener)
        rvUsers.layoutManager = manager
        rvUsers.adapter = userAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    private val itemClickListener = object : IUserItemClickListener<UserEntity> {
        override fun openDetail(entity: UserEntity) {
            openItemDetail(entity.id)
        }
    }


    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }


    private fun openItemDetail(id: Int) {
        this.startActivity(DetailActivity.newInstance(this, id))
    }
}
