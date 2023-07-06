package com.batuhanbardakkaya.carhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.batuhanbardakkaya.carhelper.databinding.ActivityKayitBinding
import com.batuhanbardakkaya.carhelper.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val currentUser = auth.currentUser

        if (currentUser != null){
            val intent = Intent(this,MainScreen::class.java)
            startActivity(intent)
            finish()
        }

    }


    fun girisyap(view : View){
        val email = binding.klmail.text.toString()
        val password = binding.klsifre.text.toString()

        if(email.equals("") || password.equals("")){
            Toast.makeText(this,"Email ve şifre giriniz!",Toast.LENGTH_LONG).show()

        }else{

            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
            val intent = Intent(this,MainScreen::class.java)
            startActivity(intent)
            finish()
            }.addOnFailureListener {
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }



    }

    fun btnkayit(view : View){
        val intent = Intent(this,ActivityKayit::class.java)
        startActivity(intent)
        finish()
    }
}//val intent = Intent(this,MainScreen::class.java)
//startActivity(intent)
//finish()