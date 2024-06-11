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
import mylogin.com.databinding.FragmentAddresAddBinding
import mylogin.com.databinding.FragmentPhoneAddBinding
import mylogin.com.model.Addres
import mylogin.com.model.Phone
import mylogin.com.viewModel.AddresViewModel
import mylogin.com.viewModel.PhoneViewModel

class AddresAddFragment: Fragment()  {

    private lateinit var binding: FragmentAddresAddBinding

    private val addresViewModel by viewModels<AddresViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddresAddBinding.inflate(inflater, container, false)

        binding.addresBtn.setOnClickListener {

            val street = binding.direccionInput.text.toString()
            val height = binding.alturaInput.text.toString()
            val postalcode = binding.codigoPostalInput.text.toString()
            val state =binding.provinciaInput.text.toString()


            if (street.isNotEmpty() && height.isNotEmpty() && postalcode.isNotEmpty() && state.isNotEmpty()) {
                // Creo el objeto

                val addres = Addres(id = 0, street = street, height = height, postalcode = postalcode, state=state )

                addresViewModel.insertAddres(addres=addres)

                Log.d("AddFragment", "Dirreccion creado! $addres")
                // Navego al listado
                findNavController().navigate(R.id.action_addFragmentAddres_to_listFragmentAddres)

            } else {
                Toast.makeText(requireContext(), "Complete todos los campos!", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return binding.root
    }



}