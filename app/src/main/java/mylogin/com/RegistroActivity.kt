package mylogin.com

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import mylogin.com.R.*
import mylogin.com.R.id.*
import mylogin.com.construc.Usuario
import java.io.Serializable


class RegistroActivity : AppCompatActivity() {

    private lateinit var editTextNombreCompleto: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextContraseña: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.form)

        editTextNombreCompleto = findViewById(editTextTextNombreCompleto)
        editTextCorreo = findViewById(editTextTextEmailAddress)
        editTextContraseña = findViewById(editTextTextPassword3)

        val buttonRegistrar: Button = findViewById(button4)

    /*    val registerLink: TextView = findViewById(register_link)
        registerLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("form.xml"))
            startActivity(intent)
        }*/

        class Usuario(val nombre: String, val correo: String, val contraseña: String)

        var usuarioRegistrado: Usuario? = null

        buttonRegistrar.setOnClickListener {
            val nombreCompleto = editTextNombreCompleto.text.toString()
            val correo = editTextCorreo.text.toString()
            val contraseña = editTextContraseña.text.toString()

            if (nombreCompleto.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nuevoUsuario = Usuario(nombreCompleto, correo, contraseña)
            usuarioRegistrado = nuevoUsuario

            Toast.makeText(this, "Usuario creado con éxito", Toast.LENGTH_SHORT).show()

            // Llamar a la actividad MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuarioRegistrado", usuarioRegistrado as Serializable)
            startActivity(intent)
        }

        // Bloque adicional agregado
        buttonRegistrar.setOnClickListener {
            val nombreCompleto = editTextNombreCompleto.text.toString()
            val correo = editTextCorreo.text.toString()
            val contraseña = editTextContraseña.text.toString()

            if (nombreCompleto.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //se crea el usuario para SharedPreferences

            val preferences = getSharedPreferences(CREDENTIALS, MODE_PRIVATE)
            val edit= preferences.edit()
            val usuario= Usuario(name = nombreCompleto, email = correo, password = contraseña)
            val gson= Gson()
            val usuarioInJsonFormatter = gson.toJson(usuario)

            edit.putString("usuario",usuarioInJsonFormatter)
            edit.apply()

            val intent = Intent(this, MainActivity::class.java)
           // intent.putExtra("nombreCompleto", nombreCompleto)
           // intent.putExtra("correo", correo)
           // intent.putExtra("contraseña", contraseña)
            startActivity(intent)
            Toast.makeText(this, "Usuario creado con éxito", Toast.LENGTH_SHORT).show()
        }
    }
    companion object { //static
        const val CREDENTIALS = "Credenciales"
    }
}
