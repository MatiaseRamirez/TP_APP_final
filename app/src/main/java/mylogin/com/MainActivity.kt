package mylogin.com

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import mylogin.com.construc.Usuario
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button
    lateinit var twregister :  TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)
        twregister=findViewById(R.id.register_link)

        twregister.setOnClickListener {
            val intent=Intent(this,RegistroActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener{
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Log.i( "Test Credentials", "Username : $username and Password : $password")

            if (validateData(username, password) == true) {

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username",username)
                startActivity(intent)
              //  goToHomeActivity()

            } else {
                Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show()
            }

        }



    }

    private fun validateData(name: String?, password: String?): Boolean {
        var user = Usuario("","","")
        try {
            val preferecias = getSharedPreferences(RegistroActivity.CREDENTIALS, MODE_PRIVATE)
            val personJson = preferecias.getString("usuario", "")

            val gson = Gson()
            user = gson.fromJson(personJson, Usuario::class.java)

        } catch (e: Exception) {
        }

        return if (name == user.name && password == user.password) {
            true
        } else {
            false
        }
    }
    private fun goToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }}

//comentario