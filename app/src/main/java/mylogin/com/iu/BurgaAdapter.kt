package mylogin.com.iu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import mylogin.com.R
import mylogin.com.construc.Burga
import mylogin.com.databinding.ItemRecyclerviewBurgaBinding


class BurgaAdapter : RecyclerView.Adapter<BurgaAdapter.BurgaAdapterViewHolder>() {

    val burgaList = arrayListOf<Burga>(
        Burga(R.drawable.burga, "Destructora","La mejor burga", 3000),
        Burga(R.drawable.burga, "Estudiante","La mejor burga", 2000),
        Burga(R.drawable.burga, "Clasica","La mejor burga", 1500),
        Burga(R.drawable.burga, "Picante","La mejor burga", 1500),
        Burga(R.drawable.burga, "3 Estrellas","La mejor burga", 3000),
        Burga(R.drawable.burga, "Crunchi Burger","La mejor burga", 4000),
        )

    inner class BurgaAdapterViewHolder(private val binding: ItemRecyclerviewBurgaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(burga: Burga) {
            with(binding) {
                binding.nameTextView.text = burga.name
                binding.descriptionTextView.text = burga.description
                binding.priceTextView.text = burga.price.toString()
                Glide.with(binding.root.context).load(burga.image)
                    .apply(RequestOptions.bitmapTransform(CircleCrop())).into(binding.imgBurga)



                root.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putSerializable("burga", burga)
                    itemView.findNavController()
                        .navigate(R.id.action_listFragmentBurga_to_addFragmentRepair, bundle)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgaAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewBurgaBinding.inflate(inflater, parent, false)
        val viewHolder = BurgaAdapterViewHolder(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: BurgaAdapterViewHolder, position: Int) {
        val burga = burgaList.get(position)
        holder.bind(burga=burga)
    }

    override fun getItemCount(): Int {
        return burgaList.size
    }


}