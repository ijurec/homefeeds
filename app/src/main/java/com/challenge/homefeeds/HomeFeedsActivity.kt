package com.challenge.homefeeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.challenge.homefeeds.ui.main.HomeFeedsFragment

class HomeFeedsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_feeds_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFeedsFragment.newInstance())
                .commitNow()
        }
    }
}