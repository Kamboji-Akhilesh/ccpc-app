package com.example.ccpc

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class Home_Activity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navview: NavigationView
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#2C69F0AE")))
        supportActionBar!!.setTitle("")

        mAuth = FirebaseAuth.getInstance()

        drawerLayout = findViewById(R.id.drawerLayout)

        navview = findViewById(R.id.navview)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navview.setNavigationItemSelectedListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.cloudcounselage.com/iac/?utm_source=CLARK&utm_medium=hackathon_2022&utm_campaign=CloudCounselage")
            startActivity(openURL)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        if(item.itemId==R.id.logout){
            mAuth.signOut()
            val intent = Intent(this,Welcome_Activity::class.java)
            startActivity(intent)
            return true
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_,menu)
        return super.onCreateOptionsMenu(menu)
    }
}