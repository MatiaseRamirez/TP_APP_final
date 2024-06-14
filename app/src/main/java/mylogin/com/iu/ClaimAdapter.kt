package mylogin.com.iu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import mylogin.com.R
import mylogin.com.databinding.ItemRecyclerviewClaimBinding
import mylogin.com.model.Claim

class ClaimAdapter: RecyclerView.Adapter<ClaimAdapter.ClaimViewHolder>() {

    private var claimList = emptyList<Claim>()
    inner class ClaimViewHolder(private val binding: ItemRecyclerviewClaimBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(claim: Claim) {
            with(binding) {
                tvId.text = claim.id.toString()
                tvTitulo.text = claim.title
                tvDescripcion.text=claim.description



                root.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putSerializable("claim", claim)
                    itemView.findNavController().navigate(R.id.action_listFragmentClaim_to_updateFragmentClaim, bundle)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaimViewHolder {
        val binding = ItemRecyclerviewClaimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClaimViewHolder(binding = binding)
    }
    override fun onBindViewHolder(holder: ClaimViewHolder, position: Int) {
        val claim = claimList.get(position)
        holder.bind(claim = claim)
    }

    override fun getItemCount(): Int {
        return claimList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(claims: List<Claim>) {
        claimList = claims
        notifyDataSetChanged()
    }


}