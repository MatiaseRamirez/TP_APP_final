package mylogin.com.iu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import mylogin.com.R
import mylogin.com.databinding.ItemRecyclerviewAddresBinding
import mylogin.com.model.Addres

class AddresAdapter: RecyclerView.Adapter<AddresAdapter.AddresViewHolder>() {

    private var addresList = emptyList<Addres>()
    inner class AddresViewHolder(private val binding: ItemRecyclerviewAddresBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(addres: Addres) {
            with(binding) {
                tvId.text = addres.id.toString()
                tvDireccion.text = addres.street
                tvaltura.text=addres.height
                tvcp.text=addres.postalcode
                tvprov.text=addres.state


                root.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putSerializable("addres", addres)
                    itemView.findNavController().navigate(R.id.action_listFragmentAddres_to_updateFragmentAddres, bundle)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddresViewHolder {
        val binding = ItemRecyclerviewAddresBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddresViewHolder(binding = binding)
    }
    override fun onBindViewHolder(holder: AddresViewHolder, position: Int) {
        val addres = addresList.get(position)
        holder.bind(addres = addres)
    }

    override fun getItemCount(): Int {
        return addresList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(address: List<Addres>) {
        addresList = address
        notifyDataSetChanged()
    }


}