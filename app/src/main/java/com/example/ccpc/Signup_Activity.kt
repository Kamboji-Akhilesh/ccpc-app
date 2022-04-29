package com.example.ccpc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signup_Activity : AppCompatActivity() {

    private lateinit var back: ImageButton
    private lateinit var login: Button
    private lateinit var oemail: EditText
    private lateinit var opassword: EditText
    private lateinit var oconpassword: EditText
    private lateinit var signup: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()

        back = findViewById(R.id.btn_back)
        login = findViewById(R.id.btn_login)
        oemail = findViewById(R.id.email)
        opassword = findViewById(R.id.password)
        oconpassword = findViewById(R.id.con_password)
        signup = findViewById(R.id.btn_signup)

        back.setOnClickListener {
            val intent = Intent(this, Welcome_Activity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            val intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener {
            val email = oemail.text.toString()
            val password = opassword.text.toString()
            val conpassword = oconpassword.text.toString()
            if (password == conpassword){
                signup(email,password)
            }
            else{
                Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signup(email: String, password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, Profile_Activity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Authentication failed.",Toast.LENGTH_SHORT).show()
                }
            }
    }

}