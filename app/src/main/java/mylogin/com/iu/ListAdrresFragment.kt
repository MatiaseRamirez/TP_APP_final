package mylogin.com.iu

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mylogin.com.R
import mylogin.com.databinding.FragmentListAddresBinding
import mylogin.com.viewModel.AddresViewModel

class ListAdrresFragment: Fragment(), MenuProvider {

        private lateinit var binding: FragmentListAddresBinding

        private val addresViewModel by viewModels<AddresViewModel>()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentListAddresBinding.inflate(inflater, container, false)


            val adapter = AddresAdapter()
            binding.recyclerViewAddres.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewAddres.adapter = adapter


            // Linea divisoria
            val divider = DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation)
            binding.recyclerViewAddres.addItemDecoration(divider)

            val menuHost: MenuHost = requireActivity()
            menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)



            binding.btnAdd.setOnClickListener {
                findNavController().navigate(R.id.action_listFragmentAddres_to_addFragmentAddres)
            }


            addresViewModel.readAllData.observe(viewLifecycleOwner) { addresList ->
                adapter.setList(address = addresList)
            }



            return binding.root
        }

        private fun deleteAll() {
            val dialog = AlertDialog.Builder(requireContext())

            dialog.setTitle("¿Eliminar Todos?")
            dialog.setMessage("¿Esta seguro que desea eliminar a todos los usuarios?")

            dialog.setNegativeButton("No") { _,_ ->
                return@setNegativeButton
            }

            dialog.setPositiveButton("Yes") { _,_ ->
                addresViewModel.deleteAllAddress()
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