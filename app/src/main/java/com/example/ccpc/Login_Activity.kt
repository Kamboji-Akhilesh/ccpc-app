package com.example.ccpc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login_Activity : AppCompatActivity() {

    private lateinit var back: ImageButton
    private lateinit var signup: Button
    private lateinit var oemail: EditText
    private lateinit var opassword: EditText
    private lateinit var login: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        back = findViewById(R.id.btn_back)
        signup = findViewById(R.id.btn_signup)
        oemail = findViewById(R.id.email)
        opassword = findViewById(R.id.password)
        login = findViewById(R.id.btn_login)

        back.setOnClickListener {
            val intent = Intent(this, Welcome_Activity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener {
            val intent = Intent(this, Signup_Activity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            val email = oemail.text.toString()
            val password = opassword.text.toString()

            login(email,password)
        }
    }

    private fun login(email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, Home_Activity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "User not found",Toast.LENGTH_SHORT).show()
                }
            }
    }
}