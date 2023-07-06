package com.batuhanbardakkaya.carhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.batuhanbardakkaya.carhelper.databinding.ActivityFuelScreenBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FuelScreen : AppCompatActivity() {
    private lateinit var binding : ActivityFuelScreenBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFuelScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        auth =Firebase.auth
        firestore = Firebase.firestore

    }


    fun Onayla (view : View){

        if ( auth.currentUser != null){

        val fuelmap = hashMapOf<String,Any>()

            fuelmap.put("Kullanıcı",auth.currentUser!!.email!!)
            fuelmap.put("Kilometre",binding.AracKmTxt.text.toString())
            fuelmap.put("Tutar",binding.OdenenTutarTxt.text.toString())
            fuelmap.put("Tarih",Timestamp.now())

            firestore.collection("Fuels").add(fuelmap).addOnSuccessListener {
                finish()
            }.addOnFailureListener {
                    Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }



    }

}