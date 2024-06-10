package mylogin.com.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import mylogin.com.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.buyButton1.setOnClickListener {

            Toast.makeText(requireContext(), "Proximante", Toast.LENGTH_SHORT).show()
        }
        binding.buyButton2.setOnClickListener {
            Toast.makeText(requireContext(), "Proximante", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }


}




