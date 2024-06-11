package mylogin.com.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import mylogin.com.construc.Addres
import mylogin.com.databinding.FragmentAddresBinding

class AddresFragment : Fragment() {

    private lateinit var binding: FragmentAddresBinding
   // private lateinit var tvaddres: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentAddresBinding.inflate(inflater, container, false)
      /*  tvaddres = binding.tvaddres
        var addres = Addres("", "", "", "")
        val preferences = requireActivity().getSharedPreferences(ADDRESSES, MODE_PRIVATE)

        val gson = Gson()
        val addresJson = preferences.getString("addres", "")

        //PARTE DONDE  VALIDAR QUE EXISTE preferences

       val archivoexiste =archivo(requireActivity(), ADDRESSES,"addres")

        if (archivoexiste){
            Toast.makeText(requireContext(), "Existe registro guardado!", Toast.LENGTH_SHORT).show()
            addres = gson.fromJson(addresJson, Addres::class.java)
            tvaddres.setText(addresJson)
            tvaddres.setText("Direccion: " + addres.street + " " + addres.height + "\nCodigo Postal: " + addres.postalcode + "\nProvincia: " + addres.state)
            tvaddres.setVisibility(View.VISIBLE)
            }else{
                Toast.makeText(requireContext(), "No hay registro guardado", Toast.LENGTH_SHORT).show()

        }
            binding.addresBtn.setOnClickListener {
                val dirrecion = binding.direccionInput.text.toString()
                val altura = binding.alturaInput.text.toString()
                val codigopostal = binding.codigoPostalInput.text.toString()
                val provincia = binding.provinciaInput.text.toString()

                if (validateFields(dirrecion, altura, codigopostal, provincia)) {
                    val edit = preferences.edit()
                    val addres = Addres(dirrecion, altura, codigopostal, provincia)
                    val gson = Gson()
                    val addressInJsonFormat = gson.toJson(addres)

                    edit.putString("addres", addressInJsonFormat)
                    edit.apply()
                    Toast.makeText(requireContext(), "Direccion Agregado!", Toast.LENGTH_SHORT).show()
                    tvaddres.setText("Direccion: " + addres.street + " " + addres.height + "\nCodigo Postal: " + addres.postalcode + "\nProvincia: " + addres.state)
                    tvaddres.setVisibility(View.VISIBLE)

                }  else {
                    Toast.makeText(requireContext(), "Debe completar todos los campos!", Toast.LENGTH_SHORT).show()
                }
            }
*/
        return binding.root
    }

    private fun validateFields(street :String, height:String,postalcode:String,state:String ): Boolean {
        return if (street.isNotBlank() && height.isNotBlank() && postalcode.isNotBlank() && state.isNotBlank() != null) {
            true
        } else {
            false
        }
    }
    companion object {
        const val ADDRESSES = "Direcciones"
    }
    fun archivo(context: Context, prefsName: String, key: String): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        return sharedPreferences.contains(key)
    }

}