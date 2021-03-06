package com.sopt27.praisewhale.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.sopt27.praisewhale.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layout_sign_up, AgreeFragment(), "signUp").commit()
    }

    fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
        transaction.addToBackStack(null)
        transaction.replace(R.id.layout_sign_up, fragment, "signUp").commit()
    }

    fun finishFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.remove(fragment).commit()
        supportFragmentManager.popBackStack()
    }
}