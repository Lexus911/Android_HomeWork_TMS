package com.example.android_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnGoToActivity4 = findViewById<Button>(R.id.btnGoToActivity4)

        btnGoToActivity4.setOnClickListener{
            startActivity(
                Intent(this, MainActivity4::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }

        val editText3 = findViewById<TextInputEditText>(R.id.et_text3)
        val editText4 = findViewById<TextInputEditText>(R.id.et_text4)
        val button2 = findViewById<Button>(R.id.btn_Sign_up)
        val layout3 = findViewById<TextInputLayout>(R.id.textInputLayout3)
        val layout4 = findViewById<TextInputLayout>(R.id.textInputLayout4)
        val rb3 = findViewById<RadioButton>(R.id.radioButton3)
        val rb4 = findViewById<RadioButton>(R.id.radioButton4)



        val dialog = AlertDialog.Builder(this)
            .setTitle("Information")
            .setPositiveButton("OK"){dialog, _ ->
                Toast.makeText(this, "Registration is successful", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, _ ->
                dialog.cancel()
            }

        button2.setOnClickListener{

            if(editText3.text.toString().isEmpty()){
                layout3.error = "field 'e-mail' can't be empty"
                layout3.setErrorIconDrawable(R.drawable.ic_warning)

            }else if(editText4.text.toString().isEmpty()){
                layout4.error = "field 'password' can't be empty"
                layout4.setErrorIconDrawable(R.drawable.ic_warning)
            }
            else{
                layout3.isErrorEnabled = false
                layout4.isErrorEnabled = false
                dialog.setMessage("E-mail: ${editText3.text.toString()}" +
                        "\nPassword: ${editText4.text.toString()}")
                dialog.show()
            }
        }

        rb3.setOnClickListener{
            if(rb3.isChecked){
                rb4.isChecked = false

            }else{
                rb3.isChecked = true
            }

        }
        rb4.setOnClickListener{
            if(rb4.isChecked){
                rb3.isChecked = false

            }else{
                rb4.isChecked = true
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}