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
import mylogin.com.databinding.FragmentClaimUpdateBinding

import mylogin.com.model.Claim
import mylogin.com.viewModel.ClaimViewModel

class ClaimUpdateFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentClaimUpdateBinding
    private val claimViewModel by viewModels<ClaimViewModel>()

    private var claim: Claim? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClaimUpdateBinding.inflate(inflater, container, false)

        claim = arguments?.getSerializable("claim") as Claim // Bundle
        binding.claimTitleInput.setText(claim?.let { it.title })
        binding.claimDescriptionInput.setText(claim?.let { it.description })


        binding.submitClaimButton.setOnClickListener {
            validateFields(claim!!)
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

    private fun validateFields(claim: Claim) {

        val title = binding.claimTitleInput.text.toString()
        val description = binding.claimDescriptionInput.text.toString()



        if (title.isNotEmpty() && description.isNotEmpty()) {

            val claim = claim.copy(title = title, description = description)
            claimViewModel.updateClaim(claim=claim)
            Toast.makeText(requireContext(), " La modificación fue realizada con éxito!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentClaim_to_listFragmentClaim)

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
                deleteClaim()
                true
            }

            else -> {
                false
            }
        }
    }

    private fun deleteClaim() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Desea Eliminar?")
        dialog.setMessage("Esta seguro que desea eliminar ha ${claim!!.title}")

        dialog.setNegativeButton(getString(R.string.no_option)) { _,_ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Yes") { _, _ ->
            claimViewModel.deleteClaim(claim = claim!!)
            Toast.makeText(requireContext(), "User eliminado!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentClaim_to_listFragmentClaim)
        }

        dialog.create().show()
    }


}