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
import mylogin.com.databinding.FragmentAddresUpdateBinding
import mylogin.com.model.Addres
import mylogin.com.viewModel.AddresViewModel

class AddresUpdateFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentAddresUpdateBinding
    private val addresViewModel by viewModels<AddresViewModel>()

    private var addres: Addres? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddresUpdateBinding.inflate(inflater, container, false)

        addres = arguments?.getSerializable("addres") as Addres // Bundle
        binding.direccionInput.setText(addres?.let { it.street })
        binding.alturaInput.setText(addres?.let { it.height })
        binding.codigoPostalInput.setText(addres?.let { it.postalcode })
        binding.provinciaInput.setText(addres?.let { it.state })

        binding.addresBtn.setOnClickListener {
            validateFields(addres!!)
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

    private fun validateFields(addres: Addres) {

        val street = binding.direccionInput.text.toString()
        val height = binding.alturaInput.text.toString()
        val postalcode = binding.codigoPostalInput.text.toString()
        val state =binding.provinciaInput.text.toString()


        if (street.isNotEmpty() && height.isNotEmpty() && postalcode.isNotEmpty()&& state.isNotEmpty()) {

            val addres = addres.copy(street = street, height = height, postalcode = postalcode, state=state)
            addresViewModel.updateAddres(addres=addres)

            findNavController().navigate(R.id.action_updateFragmentAddres_to_listFragmentAddres)

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
                deleteAddres()
                true
            }

            else -> {
                false
            }
        }
    }

    private fun deleteAddres() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Desea Eliminar?")
        dialog.setMessage("Esta seguro que desea eliminar ha ${addres!!.street}")

        dialog.setNegativeButton(getString(R.string.no_option)) { _,_ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Yes") { _, _ ->
            addresViewModel.deleteAddres(addres = addres!!)
            Toast.makeText(requireContext(), "User eliminado!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentAddres_to_listFragmentAddres)
        }

        dialog.create().show()
    }


}