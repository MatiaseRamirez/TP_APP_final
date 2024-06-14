package mylogin.com.iu

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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mylogin.com.R
import mylogin.com.databinding.FragmentListPhoneBinding
import mylogin.com.viewModel.PhoneViewModel

class ListPhoneFragment : Fragment(), MenuProvider {


    private lateinit var binding: FragmentListPhoneBinding

    private val userViewModel by viewModels<PhoneViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListPhoneBinding.inflate(inflater, container, false)


        val adapter = PhoneAdapter()
        binding.recyclerViewPhone.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPhone.adapter = adapter


        // Linea divisoria
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation)
        binding.recyclerViewPhone.addItemDecoration(divider)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)



        binding.btnAdd.setOnClickListener {
            //findNavController().navigate(R.id.action_listFragmentPhone_to_updateFragmentPhone2)
            findNavController().navigate(R.id.action_listFragmentPhone_to_addFragmentPhone)
        }


        userViewModel.readAllData.observe(viewLifecycleOwner) { phoneList ->
            adapter.setList(phones = phoneList)
        }



        return binding.root
    }

    private fun deleteAll() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Eliminar Todos?")
        dialog.setMessage("¿Esta seguro que desea eliminar a todos los teléfonos?")

        dialog.setNegativeButton("No") { _,_ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Yes") { _,_ ->
            Toast.makeText(requireContext(), "Las teléfonos fueron eliminadas con éxito! ", Toast.LENGTH_SHORT).show()

            userViewModel.deleteAllPhones()
        }

        dialog.create().show()
    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.menu_delete -> {
                deleteAll()
                true
            }

            else -> {
                false
            }
        }
    }

}


