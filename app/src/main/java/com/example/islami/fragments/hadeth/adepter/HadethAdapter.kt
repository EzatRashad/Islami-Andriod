package com.example.islami.fragments.hadeth.adepter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding
import com.example.islami.fragments.hadeth.model.Hadeth

class HadethAdapter(private val hadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {

        val binding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )


        val screenWidth = parent.resources.displayMetrics.widthPixels
        binding.root.layoutParams.width = (screenWidth * 0.80).toInt()

        return HadethViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        holder.bind(hadethList[position])
    }

    override fun getItemCount(): Int = hadethList.size

    class HadethViewHolder(private val binding: ItemHadethBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hadeth: Hadeth) {
            binding.hadethTitle.text = hadeth.title
            binding.hadethDescription.text = hadeth.description
        }
    }
}
