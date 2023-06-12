package com.app.kalyanbazar.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.kalyanbazar.R
import com.app.kalyanbazar.databinding.ActivityLoginBinding
import com.app.kalyanbazar.databinding.ActivityRegisterBinding
import com.app.kalyanbazar.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityRegister : BaseActivity<ActivityRegisterBinding>(){



    override fun getLayoutResId(): Int =R.layout.activity_register

    override fun setupViews() {
        dataBinding.apply {
            tvalreadylogin.setOnClickListener {
                val intent = Intent(this@ActivityRegister, ActivityLogin::class.java)
                startActivity(intent)
            }
            btnsignup.setOnClickListener {
                val intent = Intent(this@ActivityRegister, HomeDashboardActivity::class.java)
                startActivity(intent)
            }
        }

     }

    override fun setupViewsOnResume() {
     }
}