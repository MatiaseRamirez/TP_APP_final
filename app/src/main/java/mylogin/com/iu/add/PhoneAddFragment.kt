package mylogin.com.iu.add

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import mylogin.com.R
import mylogin.com.databinding.FragmentPhoneAddBinding
import mylogin.com.model.Phone
import mylogin.com.viewModel.PhoneViewModel

class PhoneAddFragment: Fragment() {

    private lateinit var binding: FragmentPhoneAddBinding

    private val phoneViewModel by viewModels<PhoneViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneAddBinding.inflate(inflater, container, false)

        binding.btnAddPhone.setOnClickListener {

            val numero = binding.phoneNumberInput.text.toString()

            if (numero.isNotEmpty()) {
                // Creo el objeto

                val phone = Phone(id = 0, phone = numero)

                phoneViewModel.insertPhone(phone = phone)

                Log.d("AddFragment", "Telefono creado! $phone")
                // Navego al listado
                findNavController().navigate(R.id.action_addFragmentPhone_to_listFragmentPhone)

            } else {
                Toast.makeText(requireContext(), "Complete todos los campos!", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return binding.root
    }
}
