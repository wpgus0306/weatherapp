package com.example.app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyCallback.DataActivityListener
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        getDate()
    }

    @SuppressLint("SuspiciousIndentation")
    fun init() {
        val nickname = findViewById<TextView>(R.id.sampleSentence)
        val nicknameText = findViewById<EditText>(R.id.nickname)
        val image = findViewById<ImageView>(R.id.face)
        val btn2 = findViewById<Button>(R.id.searchbtn)
        val btn1 = findViewById<Button>(R.id.changebtn)

        btn1.setOnClickListener {
            //
            nickname.text = nicknameText.text.toString()
            image.setImageResource(R.drawable.ic_baseline_android_24)

        }

        btn2.setOnClickListener {
        val i=Intent(this,Main22::class.java)
            i.putExtra("today",getDate())
            i.putExtra("nickname",nickname.text.toString())
            startActivity(i)
        }

    }

    fun getDate(): String {
        val now = System.currentTimeMillis()
        val currentDate = Date(now)
        val dateFormat = SimpleDateFormat("yyyy년MM월dd일")

        Toast.makeText(
            this,
            "오늘 날짜는 " + dateFormat.format(currentDate).toString() + "입니다",
            Toast.LENGTH_SHORT
        ).show()
        return dateFormat.format(currentDate).toString()
    }
}