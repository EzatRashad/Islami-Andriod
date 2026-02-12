package com.example.islami.fragments.hadeth.adepter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding
import com.example.islami.fragments.hadeth.model.Hadeth


class HadethAdapter(val hadethList: List<Hadeth>? = null) :
    RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        val binding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HadethViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        val hadeth = hadethList?.get(position)
        holder.bind(hadeth)
    }

    override fun getItemCount(): Int = hadethList?.size ?: 0

    class HadethViewHolder(val binding: ItemHadethBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hadeth: Hadeth?) {
            binding.hadethTitle.text = hadeth?.title
            binding.hadethDescription.text = hadeth?.description
        }
    }
}
