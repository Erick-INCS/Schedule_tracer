package com.example.scheduletracer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var btnIn  : Button
    lateinit var btnOut  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIn = findViewById(R.id.btnCkin)
        btnOut = findViewById(R.id.btnCkout)

        btnIn.setOnClickListener(View.OnClickListener {
            var files: Array<String> = applicationContext.fileList()
            for (i in files) {
                Log.d("list", i.toString())
            }

            val file = File(applicationContext.filesDir, LocalDate.now().toString())
            val tm = LocalDateTime.now()
            file.appendText("check in:" + tm.hour + ":" + tm.minute + ":" + tm.second + "\n")
            Toast.makeText(this, "check in:" + tm.hour + ":" + tm.minute + ":" + tm.second, Toast.LENGTH_SHORT).show()
        })

        btnOut.setOnClickListener(View.OnClickListener {
            var files: Array<String> = applicationContext.fileList()
            for (i in files) {
                Log.d("list", i.toString())
            }

            val file = File(applicationContext.filesDir, LocalDate.now().toString())
            val tm = LocalDateTime.now()
            file.appendText("check out:" + tm.hour + ":" + tm.minute + ":" + tm.second + "\n")
            Toast.makeText(this, "check in:" + tm.hour + ":" + tm.minute + ":" + tm.second, Toast.LENGTH_SHORT).show()
        })
    }
}