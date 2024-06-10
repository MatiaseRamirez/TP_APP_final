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
import mylogin.com.construc.Favorites
import mylogin.com.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var tvfavorite:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        tvfavorite=binding.tvfavorite
        var favorites = Favorites(" ","")
        val preferences =requireActivity().getSharedPreferences(
            FAVORITES,
            Context.MODE_PRIVATE
        )
        val gson = Gson()
        val favoritesJson = preferences.getString("favorites", "")

        val archivoexiste = AddresFragment().archivo(requireContext(), FAVORITES,"favorites")

        if (archivoexiste){
            Toast.makeText(requireContext(), "Existe registro guardado!", Toast.LENGTH_SHORT).show()
            favorites = gson.fromJson(favoritesJson, Favorites::class.java)
            tvfavorite.setText(favoritesJson)
            tvfavorite.setText("Hamburguesa favorita: " + favorites.name+"\nNota: "+favorites.notes)
            tvfavorite.setVisibility(View.VISIBLE)

        }else{
            Toast.makeText(requireContext(), "No hay registro guardado", Toast.LENGTH_SHORT).show()

        }
        binding.saveFavoriteBurgerButton.setOnClickListener {
            val name = binding.favoriteBurgerInput.text.toString()
            val notes=binding.favoriteNotesInput.text.toString()
            if (validateFields(name,notes)) {
                val edit = preferences.edit()
                val favorites = Favorites(name,notes)
                val gson = Gson()
                val favoritesmInJsonFormat = gson.toJson(favorites)

                edit.putString("favorites", favoritesmInJsonFormat)
                edit.apply()
                Toast.makeText(requireContext(), "Hamburguesas favorita Agregado!", Toast.LENGTH_SHORT).show()
                tvfavorite.setText("Hamburguesa favorita: " + favorites.name+"\nNota: "+favorites.notes)
                tvfavorite.setVisibility(View.VISIBLE)

            }  else {
                Toast.makeText(requireContext(), "Debe completar todos los campos!", Toast.LENGTH_SHORT).show()
            }
        }




        return binding.root
    }
    private fun validateFields(name:String , notes:String ): Boolean {
        return if (name.isNullOrBlank() && notes.isNullOrBlank()  != null) {
            false
        } else {
            true
        }
    }
    companion object {
        const val FAVORITES = "Favoritos"
    }

}