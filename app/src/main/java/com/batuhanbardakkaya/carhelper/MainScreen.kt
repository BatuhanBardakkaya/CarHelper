package com.batuhanbardakkaya.carhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.batuhanbardakkaya.carhelper.databinding.ActivityMainScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainScreen : AppCompatActivity() {
    private lateinit var binding : ActivityMainScreenBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        auth = Firebase.auth

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.carhelper_menu,menu)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.reminder)
        {
            val intent = Intent(this,ReminderScreen::class.java)
            startActivity(intent)
        }else if (item.itemId == R.id.yakit){

            val intent = Intent(this,FuelScreen::class.java)
            startActivity(intent)
        }else if (item.itemId == R.id.cikis){
            auth.signOut()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }


}