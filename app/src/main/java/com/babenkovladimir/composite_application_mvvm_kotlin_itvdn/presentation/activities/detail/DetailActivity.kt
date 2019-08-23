package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.activities.detail


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.R
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.di.component.ViewModelComponent
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.domain.SingleUserViewModel
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.base.BaseActivity
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.entity.UserEntity


import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

import javax.inject.Inject

class DetailActivity : BaseActivity() {

    var viewModel: SingleUserViewModel? = null
        @Inject set

    private var userId: Int = 0

    companion object {
        @JvmStatic
        fun newInstance(context: Context, id: Int): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(context.getString(R.string.EXTRAS_ID), id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
        initViewModel()
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    private fun initViewModel() {
        userId = intent.getIntExtra(getString(R.string.EXTRAS_ID), 0)
        viewModel?.getItem(userId)
        viewModel?.getLiveDataItem()?.observe(this, Observer { it?.let { initTextViews(it) } })
    }

    private fun initTextViews(user: UserEntity) {
        txtDetailId.text = user.id.toString()
        txtDetailName.text = user.name
        txtDetailSurname.text = user.surname
        txtDetailFathername.text = user.fathername
        initActionBar(user.name)
    }

    private fun initActionBar(title: String) {
        Objects.requireNonNull(supportActionBar)?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
