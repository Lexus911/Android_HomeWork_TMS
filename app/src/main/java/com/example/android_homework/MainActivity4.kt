package com.example.android_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val editText = findViewById<TextInputEditText>(R.id.et_text)
        val editText2 = findViewById<TextInputEditText>(R.id.et_text2)
        val button = findViewById<Button>(R.id.btn_displayText)
        val layout1 = findViewById<TextInputLayout>(R.id.textInputLayout)
        val layout2 = findViewById<TextInputLayout>(R.id.textInputLayout2)


        val dialog = AlertDialog.Builder(this)
            .setTitle("Information")
            .setPositiveButton("OK"){dialog, _ ->
                Toast.makeText(this, "Registration is successful", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, _ ->
                dialog.cancel()
            }

        button.setOnClickListener{

            if(editText.text.toString().isEmpty()){
                layout1.error = "field 'e-mail' can't be empty"
                layout1.setErrorIconDrawable(R.drawable.ic_warning)

            }else if(editText2.text.toString().isEmpty()){
                layout2.error = "field 'password' can't be empty"
                layout2.setErrorIconDrawable(R.drawable.ic_warning)
            }
            else{
                layout1.isErrorEnabled = false
                layout2.isErrorEnabled = false
                dialog.setMessage("E-mail: ${editText.text.toString()}" +
                        "\nPassword: ${editText2.text.toString()}")
                dialog.show()
            }
        }
    }
}