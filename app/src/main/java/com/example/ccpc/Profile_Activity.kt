package com.example.ccpc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Profile_Activity : AppCompatActivity() {

    private lateinit var submit: Button
    private lateinit var oclgname: EditText
    private lateinit var ofullname: EditText
    private lateinit var oage: EditText
    private lateinit var ophnno: EditText
    private lateinit var mdref: DatabaseReference


    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()

        submit = findViewById(R.id.btn_submit)
        oclgname = findViewById(R.id.clgname)
        ofullname = findViewById(R.id.fullname)
        ophnno = findViewById(R.id.phoneno)
        oage = findViewById(R.id.age)


        submit.setOnClickListener {
            val clgname = oclgname.text.toString()
            val fullname = ofullname.text.toString()
            val phnno = ophnno.text.toString()
            val age = oage.text.toString()
            addusertodatabase(clgname,fullname,phnno,age,mAuth.currentUser?.uid!!)
            val intent = Intent(this,Home_Activity::class.java)
            startActivity(intent)
        }
    }

    private fun addusertodatabase(clgname: String, fullname: String, phnno: String, age: String,uid: String){
        mdref = FirebaseDatabase.getInstance().getReference()
        mdref.child("user").child(uid).setValue(User(clgname,fullname,phnno,age,uid))
    }
}