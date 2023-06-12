package com.app.kalyanbazar.activity


import android.content.Intent
import com.app.kalyanbazar.R
import com.app.kalyanbazar.databinding.ActivityLoginBinding
import com.app.kalyanbazar.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityLogin : BaseActivity<ActivityLoginBinding>(){


    override fun getLayoutResId(): Int =R.layout.activity_login

    override fun setupViews() {
        dataBinding.apply {
            tvregister.setOnClickListener {
                val intent = Intent(this@ActivityLogin, ActivityRegister::class.java)
                startActivity(intent)
            }

            login.setOnClickListener {
                val intent = Intent(this@ActivityLogin, HomeDashboardActivity::class.java)
                startActivity(intent)
            }
        }
     }

    override fun setupViewsOnResume() {
     }
}