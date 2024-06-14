package mylogin.com.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import mylogin.com.construc.Claim
import mylogin.com.databinding.FragmentClaimBinding

class ClaimsFragment : Fragment() {

    private lateinit var binding: FragmentClaimBinding
    private lateinit var tvclaim: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClaimBinding.inflate(inflater, container, false)
        /*

        tvclaim=binding.tvclaim
        var claim = Claim(" ","")
        val preferences =requireActivity().getSharedPreferences(
            CLAIMS,
            Context.MODE_PRIVATE
        )
        val gson = Gson()
        val claimJson = preferences.getString("claim", "")

        val archivoexiste = AddresFragment().archivo(requireContext(), CLAIMS,"claim")

        if (archivoexiste){
            Toast.makeText(requireContext(), "Existe registro guardado!", Toast.LENGTH_SHORT).show()
            claim = gson.fromJson(claimJson, Claim::class.java)
            tvclaim.setText(claimJson)
            tvclaim.setText("Titulo del Reclamo: " + claim.title+"\n Descripcion: "+claim.description)
            tvclaim.setVisibility(View.VISIBLE)

        }else{
            Toast.makeText(requireContext(), "No hay registro guardado", Toast.LENGTH_SHORT).show()

        }
        binding.submitClaimButton.setOnClickListener {
            val title = binding.claimTitleInput.text.toString()
            val description=binding.claimDescriptionInput.text.toString()
            if (validateFields(title,description)) {
                val edit = preferences.edit()
                val claim = Claim(title,description)
                val gson = Gson()
                val claimInJsonFormat = gson.toJson(claim)

                edit.putString("claim", claimInJsonFormat)
                edit.apply()
                Toast.makeText(requireContext(), "Reclamo Agregado!", Toast.LENGTH_SHORT).show()
                tvclaim.setText("Titulo del Reclamo: " + claim.title+"\n Descripcion: "+claim.description)

            }  else {
                Toast.makeText(requireContext(), "Debe completar todos los campos!", Toast.LENGTH_SHORT).show()
            }
        }



    */

        return binding.root


    }

    private fun validateFields(title: String, description: String): Boolean {
        return if (title.isNullOrBlank() && description.isNullOrBlank() != null) {
            false
        } else {
            true
        }
    }

    companion object {
        const val CLAIMS = "Reclamos"
    }
}
