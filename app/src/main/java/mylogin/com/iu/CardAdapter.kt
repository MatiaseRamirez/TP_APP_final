package mylogin.com.iu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import mylogin.com.R
import mylogin.com.databinding.ItemRecyclerviewCardBinding
import mylogin.com.model.Card

class CardAdapter: RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var cardList = emptyList<Card>()
    inner class CardViewHolder(private val binding: ItemRecyclerviewCardBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card) {
            with(binding) {
                tvId.text = card.id.toString()
                tvCard.text = card.numero
                tvfechavenc.text=card.date
                tvname.text=card.name


                root.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putSerializable("card", card)
                    itemView.findNavController().navigate(R.id.action_listFragmentCard_to_updateFragmentCard, bundle)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemRecyclerviewCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding = binding)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList.get(position)
        holder.bind(card = card)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(cards: List<Card>) {
        cardList = cards
        notifyDataSetChanged()
    }


}