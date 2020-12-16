package com.example.praisewhale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.praisewhale.fragment.CardFragment
import com.example.praisewhale.fragment.MainFragment
import com.example.praisewhale.fragment.PraiseLevelFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mainFragment by lazy { MainFragment() }
    private val collectionFragment by lazy { CardFragment() }
    private val praiseLevelFragment by lazy { PraiseLevelFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initBottomNav()
    }

    private fun initBottomNav() {
        bottomNavigationView.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_main -> {
                        changeFragment(mainFragment)
                    }
                    R.id.menu_collection -> {
                        changeFragment(collectionFragment)
                    }
                    R.id.menu_praiseLevel -> {
                        changeFragment(praiseLevelFragment)
                    }
                }
                true
            }
            selectedItemId = R.id.menu_main
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout_fragmentContainer, fragment).commit()
    }

}