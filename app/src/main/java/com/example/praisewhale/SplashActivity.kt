package com.example.praisewhale

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.praisewhale.data.RequestSignIn
import com.example.praisewhale.data.RequestSignUp
import com.example.praisewhale.data.ResponseToken
import com.example.praisewhale.signup.SignUpActivity
import com.example.praisewhale.signup.SignUpFragment
import com.example.praisewhale.util.MyApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import javax.xml.datatype.DatatypeConstants.DURATION

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val image : ImageView = findViewById(R.id.img_splash)
        Glide.with(this)
            .asGif()
            .load(R.drawable.splash4)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(image)

        Handler(Looper.getMainLooper()).postDelayed ({
            val nickname = MyApplication.mySharedPreferences.getValue("nickName","")
            if(nickname == "")
                startActivity(Intent(this, SignUpActivity::class.java))
            else
                signIn(nickname)
        }, 4000)
    }

    private fun signIn(nickname : String) {
        val body = RequestSignIn(nickName = nickname)
        val call: Call<ResponseToken> = CollectionImpl.service.signIn(body)
        call.enqueue(object : Callback<ResponseToken> {
            override fun onFailure(call: Call<ResponseToken>, t: Throwable) {
                Log.d("response", t.localizedMessage!!)
            }
            override fun onResponse(
                call: Call<ResponseToken>,
                response: Response<ResponseToken>
            ) {
                Log.d("response", response.body().toString())
                response.takeIf { it.isSuccessful }
                    ?.body()
                    ?.let {
                        MyApplication.mySharedPreferences.setValue("token", it.data.accessToken)
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    } ?: Toast.makeText(this@SplashActivity, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}