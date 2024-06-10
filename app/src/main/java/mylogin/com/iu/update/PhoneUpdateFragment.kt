package mylogin.com.iu.update

import android.os.Bundle
import android.view.LayoutInflater
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

abstract class PhoneUpdateFragment : Fragment(), MenuProvider {

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


        binding.btnUpdateUser.setOnClickListener {
            validateFields(phone!!)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    private fun validateFields(phone: Phone) {
        val numero = binding.etPhone.text.toString()

        if (numero.isNotEmpty()) {

            val numero = phone.copy(phone = numero)

            phoneViewModel.updatePhone(phone = numero)

            findNavController().navigate(R.id.action_updateFragmentPhone_to_listFragmentPhone2)

        } else {
            Toast.makeText(requireContext(), "Complete todos los campos!", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
