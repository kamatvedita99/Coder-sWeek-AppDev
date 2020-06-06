package com.example.playorshop
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.example.playorshop.FirstActivity as FirstActivity
import com.example.playorshop.SecondActivity as SecondActivity
import android.app.Activity
import com.example.playorshop.MainActivity as MainActivity
import android.util.ArraySet
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) 


    
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        play.setOnClickListener(){
            var intent=Intent(this,FirstActivity::class.java)
            startActivity(intent)
        }

        shop.setOnClickListener(){
            var intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }

        providers = Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        button2.setOnClickListener {
            AuthUI.getInstance().signOut(this@HomeActivity)
                .addOnCompleteListener {
                    button2.isEnabled=false
                    showSignInOptions()
                }
                .addOnFailureListener {
                        e-> Toast.makeText(this@HomeActivity,e.message, Toast.LENGTH_SHORT).show()
                }
        }

    }

    var providers: MutableList<AuthUI.IdpConfig>? = null
    private val MY_REQUEST_CODE: Int = 7117
    private fun showSignInOptions()
    {
        startActivityForResult(providers?.let {
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                it
            ).build()
        },MY_REQUEST_CODE)
    }

}
    