package mylogin.com.iu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mylogin.com.databinding.FragmentListBurgaBinding


class ListBurgaFragment : Fragment() {

    private lateinit var binding: FragmentListBurgaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBurgaBinding.inflate(inflater, container, false)

        val adapter = BurgaAdapter()
        binding.recyclerViewBurga.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewBurga.adapter = adapter

        // Linea Divisoria
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation)
        binding.recyclerViewBurga.addItemDecoration(divider)


        return binding.root
    }
}
