package com.example.rockpaperscissor

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.navigation.findNavController
import com.example.rockpaperscissor.databinding.ActivityLastBinding
import com.example.rockpaperscissor.databinding.ActivitySecondBinding

class LastActivity : AppCompatActivity() {
    lateinit var binding:ActivityLastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        toMainActivity()
//        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        startActivity(intent)
    }


}