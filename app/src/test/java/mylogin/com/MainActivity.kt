package mylogin.com

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import mylogin.com.construc.Usuario


class Usuario(val nombre: String, val correo: String, val contraseña: String)

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginBtn: Button
    lateinit var usuarioRegistrado: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)

        // Obtener los datos pasados desde RegistroActivity
        val nombreCompleto = intent.getStringExtra("nombreCompleto") ?: ""
        val correo = intent.getStringExtra("correo") ?: ""
        val contraseña = intent.getStringExtra("contraseña") ?: ""

        // Inicializar el objeto usuarioRegistrado con los datos obtenidos
        usuarioRegistrado = intent.getSerializableExtra("usuarioRegistrado") as Usuario
        // Configurar el OnClickListener para el botón de login
        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Validar las credenciales ingresadas con las del usuario registrado
            if (username == usuarioRegistrado.correo && password == usuarioRegistrado.contraseña) {
                // Inicio de sesión exitoso
                Log.i("Test Credentials", "Inicio de sesión exitoso")
            } else {
                // Credenciales incorrectas
                Log.i("Test Credentials", "Credenciales incorrectas")
            }
        }
    }
}
