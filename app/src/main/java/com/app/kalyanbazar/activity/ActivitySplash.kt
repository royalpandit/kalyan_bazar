package com.app.kalyanbazar.activity

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.app.kalyanbazar.R
import com.app.kalyanbazar.databinding.ActivitySplashBinding
import com.app.kalyanbazar.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivitySplash : BaseActivity<ActivitySplashBinding>() {


    override fun getLayoutResId(): Int =R.layout.activity_splash

    override fun setupViews() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    override fun setupViewsOnResume() {
     }
}