package com.e.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var username: AppCompatEditText
    private lateinit var password: AppCompatEditText
    private lateinit var login: MaterialButton
    private lateinit var reset: MaterialButton
    private lateinit var contextView: ConstraintLayout

    private lateinit var connectManager: ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "BReceiver App"
        init()
        contextView = findViewById(R.id.main_context_view)

        connectManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        login.setOnClickListener {

            if((username.editableText == null) or (password.editableText == null)){
                Snackbar.make(contextView, "Username or password is empty", Snackbar.LENGTH_LONG).show()


            }else{
                val mUsername: String = username.editableText.toString()
                val mPassword: String = password.editableText.toString()

                if(mUsername == "admin" && mPassword == "123456"){
                    val networkInfo = connectManager.activeNetworkInfo

                    if(networkInfo!!.isAvailable){
                        Toast.makeText(applicationContext, "Network is available!", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }

        reset.setOnClickListener {
            if(username.editableText != null || password.editableText != null){
                username.text!!.clear()
                password.text!!.clear()
            }
        }

    }

    fun init(){
        username = findViewById(R.id.ET_username)
        password = findViewById(R.id.ET_password)
        login = findViewById(R.id.BTN_login)
        reset = findViewById(R.id.BTN_reset)
    }
}
