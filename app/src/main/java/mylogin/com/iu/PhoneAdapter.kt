package mylogin.com.iu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import mylogin.com.R
import mylogin.com.databinding.ItemRecyclerviewPhoneBinding
import mylogin.com.model.Phone

class PhoneAdapter: RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    private var phoneList = emptyList<Phone>()
    inner class PhoneViewHolder(private val binding: ItemRecyclerviewPhoneBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(phone: Phone) {
            with(binding) {
                tvId.text = phone.id.toString()
                tvphone.text = phone.phone.toString()


                root.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putSerializable("phone", phone)
                    itemView.findNavController().navigate(R.id.action_listFragmentPhone_to_updateFragmentPhone, bundle)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val binding = ItemRecyclerviewPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhoneViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = phoneList.get(position)
        holder.bind(phone = phone)
        //holder.itemView.findNavController()
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    //override fun getItemCount(): Int = userList.size


    @SuppressLint("NotifyDataSetChanged")
    fun setList(phones: List<Phone>) {
        phoneList = phones
        notifyDataSetChanged()
    }


}