package com.example.rockpaperscissor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.rockpaperscissor.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeToastMsg("Second activity : Oncreate")
        Log.i("test","Second activity : Oncreate")
        binding.nextButton.setOnClickListener {
            val intent = Intent(this,LastActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        makeToastMsg("Second activity : onRestart")
        Log.i("test","Second activity : onRestart")
    }

    override fun onStart() {
        super.onStart()
        makeToastMsg("Second activity : OnStart")
        Log.i("test","Second activity : OnStart")
    }

    override fun onResume() {
        super.onResume()
        makeToastMsg("Second activity : OnResume")
        Log.i("test","Second activity : OnResume")

    }

    override fun onPause() {
        super.onPause()
        makeToastMsg("Second activity : OnPause")
        Log.i("test","Second activity : OnPause")

    }

    override fun onStop() {
        super.onStop()
        makeToastMsg("Second activity : OnStop")
        Log.i("test","Second activity : OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        makeToastMsg("Second activity : OnDestroy")
        Log.i("test","Second activity : OnDestroy")
    }
    fun makeToastMsg(msg:String)
    {
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }

}