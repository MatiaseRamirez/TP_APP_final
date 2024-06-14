package mylogin.com.iu.add

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import mylogin.com.R
import mylogin.com.databinding.FragmentCardAddBinding
import mylogin.com.model.Card
import mylogin.com.viewModel.CardViewModel

class CardAddFragment: Fragment()  {

    private lateinit var binding: FragmentCardAddBinding
    private lateinit var expiryDateInput: EditText

    private val cardViewModel by viewModels<CardViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardAddBinding.inflate(inflater, container, false)

        expiryDateInput=binding.cardFechaVencInput
        expiryDateInput.addTextChangedListener {
            val text = it.toString()
            if (text.length == 2) {
                expiryDateInput.setText("$text/")
                expiryDateInput.setSelection(text.length + 1)
            }
        }


        binding.btnAddCard.setOnClickListener {

            val numero = binding.cardNumberInput.text.toString()
            val date = binding.cardFechaVencInput.text.toString()
            val name = binding.cardHolderNameInput.text.toString()


            if (numero.isNotEmpty() && date.isNotEmpty() && name.isNotEmpty() ) {
                // Creo el objeto

                val card = Card(id = 0, numero = numero, date = date, name = name )

                cardViewModel.insertCard(card=card)

                Log.d("AddFragment", "Tarjeta creado! $card")
                // Navego al listado
                findNavController().navigate(R.id.action_addFragmentCard_to_listFragmentCard)

            } else {
                Toast.makeText(requireContext(), "Complete todos los campos!", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return binding.root
    }



}