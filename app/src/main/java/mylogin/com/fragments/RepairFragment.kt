package mylogin.com.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mylogin.com.R
import mylogin.com.databinding.FragmentRepairBinding

class RepairFragment : Fragment(){

    private lateinit var binding: FragmentRepairBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentRepairBinding.inflate(inflater, container, false)

        binding.imgRepair.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_repair_to_listFragmentBurga)

        }

        return binding.root

    }
}