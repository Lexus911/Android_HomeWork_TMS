package com.example.android_homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnGoToActivity3 = findViewById<Button>(R.id.btnGoToActivity3)

        btnGoToActivity3.setOnClickListener{
            startActivity(
                Intent(this, MainActivity3::class.java)
            )
        }

        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)

        val data: String = intent.getStringExtra(KEY) ?: getString(R.string.no_data)
        textView3.text = data
        val data2: String = intent.getStringExtra(KEY2) ?: getString(R.string.no_data)
        textView4.text = data2
        val data3: String = intent.getStringExtra(KEY3) ?: getString(R.string.android_homework_toolbar)
        supportActionBar?.title = data3
    }

    companion object{

        private const val KEY = "1"
        private const val KEY2 = "2"
        private const val KEY3 = "3"

        fun startMainActivityTextView(context: Context, string: String, string2: String){

            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, string)
            intent.putExtra(KEY2,string2)
            context.startActivity(intent)
        }
        fun startMainActivityToolBar(context: Context, string: String){

            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY3, string)
            context.startActivity(intent)
        }
    }
}