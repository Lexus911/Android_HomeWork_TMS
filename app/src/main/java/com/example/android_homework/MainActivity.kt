package com.example.android_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.android_homework.MainActivity2.Companion.startMainActivityTextView
import com.example.android_homework.MainActivity2.Companion.startMainActivityToolBar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToActivity2 = findViewById<Button>(R.id.btnGoToActivity2)

        btnGoToActivity2.setOnClickListener{
            startActivity(
                Intent(getString(R.string.open_act2_marker)))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)

        when(item.itemId){
            R.id.actionBar -> startMainActivityToolBar(this, "Second item clicked")
            R.id.texView -> startMainActivityTextView(this,textView1.text.toString(),textView2.text.toString())
            R.id.close -> finishAffinity()
            R.id.goToActivity3 -> startActivity(Intent(this, MainActivity3::class.java)
            )
        }
        return super.onOptionsItemSelected(item)
    }

}

