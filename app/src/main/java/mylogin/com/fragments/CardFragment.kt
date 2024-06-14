package mylogin.com.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.gson.Gson
import mylogin.com.construc.Card
import mylogin.com.databinding.FragmentCardBinding


class CardFragment : Fragment() {

    private lateinit var binding:FragmentCardBinding
    private lateinit var tvcard: TextView
    private lateinit var expiryDateInput:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCardBinding.inflate(inflater,container,false)
       /*
        tvcard=binding.tvcard

        expiryDateInput=binding.expiryDateInput


        expiryDateInput.addTextChangedListener {
            val text = it.toString()
            if (text.length == 2) {
                expiryDateInput.setText("$text/")
                expiryDateInput.setSelection(text.length + 1)
            }
        }


        var card = Card(" ","","")
        val preferences =requireActivity().getSharedPreferences(
            CARDS,
            Context.MODE_PRIVATE
        )
        val gson = Gson()
        val cardJson = preferences.getString("card", "")

        val archivoexiste = AddresFragment().archivo(requireContext(), CARDS,"card")

        if (archivoexiste){
            Toast.makeText(requireContext(), "Existe registro guardado!", Toast.LENGTH_SHORT).show()
            card = gson.fromJson(cardJson, Card::class.java)
            tvcard.setText(cardJson)
            tvcard.setText("Numero Tarjeta : " + card.numero+"\n fecha de vencimiento: "+card.date+"\n Titular: "+card.name)
            tvcard.setVisibility(View.VISIBLE)

        }else{
            Toast.makeText(requireContext(), "No hay registro guardado", Toast.LENGTH_SHORT).show()

        }
        binding.cardBtn.setOnClickListener {
            val numero = binding.cardNumberInput.text.toString()
            val date=binding.expiryDateInput.text.toString()
            val name=binding.cardHolderNameInput.text.toString()


            if (validateFields(numero,date,name)) {
                val edit = preferences.edit()
                val card = Card(numero,date,name)
                val gson = Gson()
                val cardsInJsonFormat = gson.toJson(card)

                edit.putString("card", cardsInJsonFormat)
                edit.apply()
                Toast.makeText(requireContext(), "Tarjeta Agregado!", Toast.LENGTH_SHORT).show()
                tvcard.setText("Numero Tarjeta : " + card.numero+"\n fecha de vencimiento: "+card.date+"\n Titular: "+card.name)
                tvcard.setVisibility(View.VISIBLE)

            }  else {
                Toast.makeText(requireContext(), "Debe completar todos los campos!", Toast.LENGTH_SHORT).show()
            }
        }


*/

        return binding.root
    }
    private fun validateFields(numero:String , date:String,name:String ): Boolean {
        return if (numero.isNullOrBlank() && date.isNullOrBlank() && name.isNullOrBlank() != null) {
            false
        } else {
            true
        }
    }
    companion object {
        const val CARDS = "Tarjetas"
    }
}


