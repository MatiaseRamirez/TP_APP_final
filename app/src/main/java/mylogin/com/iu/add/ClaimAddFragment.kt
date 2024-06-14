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
import mylogin.com.databinding.FragmentClaimAddBinding
import mylogin.com.model.Claim
import mylogin.com.viewModel.ClaimViewModel


class ClaimAddFragment: Fragment()  {

    private lateinit var binding: FragmentClaimAddBinding

    private val claimViewModel by viewModels<ClaimViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClaimAddBinding.inflate(inflater, container, false)

        binding.submitClaimButton.setOnClickListener {

            val title = binding.claimTitleInput.text.toString()
            val description = binding.claimDescriptionInput.text.toString()



            if (title.isNotEmpty() && description.isNotEmpty()) {
                // Creo el objeto

                val claim = Claim(id = 0, title = title,description = description )

                claimViewModel.insertClaim(claim=claim)

                Log.d("AddFragment", "Reclamo creado! $claim")
                // Navego al listado
                findNavController().navigate(R.id.action_addFragmentClaim_to_listFragmentClaim)

            } else {
                Toast.makeText(requireContext(), "Complete todos los campos!", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return binding.root
    }



}