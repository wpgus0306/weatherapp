package com.example.app

import android.graphics.Insets.add
import android.media.MicrophoneInfo.Coordinate3F
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class Main22 : AppCompatActivity() {
    lateinit var  date:String
    lateinit var nickname:String
    var Local= mutableListOf<Iocal>()
    lateinit var weatherView:Adapter
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main22)

        date= intent.getStringExtra("today").toString()
        nickname=intent.getStringExtra("nickname").toString()

        Toast.makeText(this,nickname+ " 님 환영합니다", Toast.LENGTH_SHORT).show()

        val title=findViewById<TextView>(R.id.sssss)
        title.text=date
        init()
    }

    fun init(){
        findXY()
        recyclerView=findViewById(R.id.recylerview22)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        weatherView=Adapter(Local)
        recyclerView.adapter=weatherView
    }

    fun findXY(){
        var line:BufferedReader?=null
        var info=""
        try {
            line= BufferedReader(InputStreamReader(resources.openRawResource(R.raw.seoulxy)))
            while (line!=null) {
                info = line!!.readLine().toString()

                if (info.equals("end")){
                    break
                }
                var infos=info.split(",")
                Local.add(Iocal(infos[0],infos[1],infos[2]))
            }
        }catch (e:IOException){
            Log.e("CSV read error : ",e.toString())
        }
    }




}


