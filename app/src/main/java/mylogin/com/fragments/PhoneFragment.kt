package mylogin.com.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import mylogin.com.construc.Phone
import mylogin.com.databinding.FragmentPhoneBinding

class PhoneFragment : Fragment() {

    private lateinit var binding: FragmentPhoneBinding
    private lateinit var tvphone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneBinding.inflate(inflater, container, false)
        tvphone=binding.tvphone

        var phone = Phone(" ")
        val preferences =requireActivity().getSharedPreferences(PHONES,MODE_PRIVATE)
        val gson = Gson()
        val phoneJson = preferences.getString("phone", "")

        val archivoexiste = AddresFragment().archivo(requireContext(), PHONES,"phone")

        if (archivoexiste){
            Toast.makeText(requireContext(), "Existe registro guardado!", Toast.LENGTH_SHORT).show()
            phone = gson.fromJson(phoneJson, Phone::class.java)
            tvphone.setText(phoneJson)
            tvphone.setText("Numero de telefono : " + phone.tel)
            tvphone.setVisibility(View.VISIBLE)

        }else{
            Toast.makeText(requireContext(), "No hay registro guardado", Toast.LENGTH_SHORT).show()

        }

        binding.phoneBtn.setOnClickListener {


        /*    val numero = binding.phoneNumberInput.text.toString()
            if (validateFields(numero)) {
                val edit = preferences.edit()
                val phone = Phone(numero)
                val gson = Gson()
                val addressInJsonFormat = gson.toJson(phone)

                edit.putString("phone", addressInJsonFormat)
                edit.apply()
                Toast.makeText(requireContext(), "Teléfono Agregado!", Toast.LENGTH_SHORT).show()
                tvphone.setText("Numero de telefono : " + phone.tel)
                tvphone.setVisibility(View.VISIBLE)

            }  else {
                Toast.makeText(requireContext(), "Debe completar todos los campos!", Toast.LENGTH_SHORT).show()
            }*/
        }


        return binding.root
    }
    private fun validateFields(numero:String ): Boolean {
        return if (numero.isNullOrBlank() != null) {
            true
        } else {
            false
        }
    }
    companion object {
        const val PHONES = "Telefonos"
    }

}