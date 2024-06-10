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
import mylogin.com.databinding.FragmentPhoneUpdateBinding
import mylogin.com.model.Phone
import mylogin.com.viewModel.PhoneViewModel

class PhoneUpdateFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentPhoneUpdateBinding
    private val phoneViewModel by viewModels<PhoneViewModel>()

    private var phone: Phone? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneUpdateBinding.inflate(inflater, container, false)

        phone = arguments?.getSerializable("phone") as Phone // Bundle

        binding.etPhone.setText(phone?.let { it.phone })
        binding.etPhone.setText(phone!!.phone)

        binding.btnUpdateUser.setOnClickListener {
            validateFields(phone!!)
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

    private fun validateFields(phonee: Phone) {
        val phone = binding.etPhone.text.toString()

        if (phone.isNotEmpty() ) {

            //val user = User(id = user.id, name = name, lastName = lastName, age = age.toInt())
            val phone = phonee.copy(phone = phone)
            phoneViewModel.updatePhone(phone = phone)

            findNavController().navigate(R.id.action_updateFragmentPhone_to_listFragmentPhone)

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
                deletePhone()
                true
            }

            else -> {
                false
            }
        }
    }

    private fun deletePhone() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Desea Eliminar?")
        dialog.setMessage("Esta seguro que desea eliminar ha ${phone!!.phone}")

        dialog.setNegativeButton(getString(R.string.no_option)) { _,_ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Yes") { _, _ ->
            phoneViewModel.deletePhone(phone=phone!!)
            Toast.makeText(requireContext(), "User eliminado!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentPhone_to_listFragmentPhone)
        }

        dialog.create().show()
    }


}

