package com.example.loginscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginscreen.ui.theme.LoginScreenTheme

class MainActivity : ComponentActivity() {
    lateinit var user:EditText;
    lateinit var password:EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        user = findViewById(R.id.user)
        password = findViewById(R.id.password)
        var loginBtn:Button = findViewById(R.id.login_btn)
        loginBtn.setOnClickListener{loginBtnHandler()}

    }

    private fun validateUser(usr: String, pwd: String): Boolean {
        return usr == "admin" && pwd == "admin"
    }

    fun loginBtnHandler() {
        if(validateUser(user.text.toString(), password.text.toString())) {
            val intent01 = Intent(this, HomeActivity::class.java)
            intent01.putExtra("usuario", user.text.toString())
            startActivity(intent01)
            return
        }

        Toast.makeText(this, "Usuario ou senha incorreto", Toast.LENGTH_LONG).show()
    }

}


