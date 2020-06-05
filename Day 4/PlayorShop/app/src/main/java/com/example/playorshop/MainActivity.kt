package com.example.playorshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.example.playorshop.FirstActivity as FirstActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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
    }
}
