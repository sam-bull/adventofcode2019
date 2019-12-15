package com.example.adventofcode2019.ui.day

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adventofcode2019.R

class DayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.day_activity)
        title = resources.getString(R.string.day_title, intent.getIntExtra("DAY", 0))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DayFragment.newInstance())
                .commitNow()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
