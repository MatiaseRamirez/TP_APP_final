package mylogin.com.iu.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import mylogin.com.R
import mylogin.com.databinding.FragmentCardUpdateBinding
import mylogin.com.model.Card
import mylogin.com.viewModel.CardViewModel

class CardUpdateFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentCardUpdateBinding
    private val cardViewModel by viewModels<CardViewModel>()

    val nothing = null
    private var card: Card? = nothing


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardUpdateBinding.inflate(inflater, container, false)

        card = arguments?.getSerializable("card") as Card // Bundle
        binding.cardNumberInput.setText(card?.let { it.numero })
        binding.cardFechaVencInput.setText(card?.let { it.date })
        binding.cardHolderNameInput.setText(card?.let { it.name })


        binding.cardBtn.setOnClickListener {
            validateFields(card!!)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        /*menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                TODO("Not yet implemented")
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        },viewLifecycleOwner, Lifecycle.State.RESUMED)*/




        return binding.root
    }

    private fun validateFields(card: Card) {

        val numero = binding.cardNumberInput.text.toString()
        val date = binding.cardFechaVencInput.text.toString()
        val name = binding.cardNumberInput.text.toString()


        if (numero.isNotEmpty() && date.isNotEmpty() && name.isNotEmpty()) {

            val card = card.copy(numero = numero, date = date, name = name)
            cardViewModel.updateCard(card=card)
            Toast.makeText(requireContext(), " La modificación fue realizada con éxito!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentCard_to_listFragmentCard)

        } else {
            Toast.makeText(requireContext(), "Complete todos los campos!", Toast.LENGTH_SHORT).show()
        }



    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.menu_delete -> {
                deleteCard()
                true
            }

            else -> {
                false
            }
        }
    }

    private fun deleteCard() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Desea Eliminar?")
        dialog.setMessage("Esta seguro que desea eliminar ha ${card!!.numero}")

        dialog.setNegativeButton(getString(R.string.no_option)) { _,_ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Yes") { _, _ ->
            cardViewModel.deleteCard(card = card!!)
            Toast.makeText(requireContext(), "User eliminado!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentCard_to_listFragmentCard)
        }

        dialog.create().show()
    }


}