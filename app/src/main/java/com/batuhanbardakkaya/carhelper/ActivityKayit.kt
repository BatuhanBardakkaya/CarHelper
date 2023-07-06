package com.batuhanbardakkaya.carhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.batuhanbardakkaya.carhelper.databinding.ActivityKayitBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ActivityKayit : AppCompatActivity() {
    private lateinit var binding: ActivityKayitBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

    }


        fun kayitol ( view : View){
        val email = binding.kytepostatxt.text.toString()
        val password = binding.kytsifre.text.toString()
        val password1 = binding.kytsfiretkr.text.toString()

            if (email.equals("") || password.equals("") || password1.equals("")){
                Toast.makeText(this,"Email adı ve şifre girin!",Toast.LENGTH_LONG).show()
            }else if (password != password1){
                Toast.makeText(this,"Şifreler Eşleşmiyor",Toast.LENGTH_LONG).show()
            }else{
                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                    val intent = Intent(this,MainScreen::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()

                }
            }



}


}