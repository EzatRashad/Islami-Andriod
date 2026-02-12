package com.route.islamic43gsunwed.chapterDetails.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterDetailsHeaderBinding
import com.example.islami.databinding.ItemVerseBinding
class VersesAdapter(
    private val verses: List<String>,
    private val chapterIndex: Int?,
    private val arabicName: String,
    private val englishName: String
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_VERSE = 1
    }

    private fun hasBasmala(): Boolean {
        val index = chapterIndex ?: 1
        return index != 1 && index != 9
    }

    override fun getItemCount(): Int = verses.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_VERSE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == TYPE_HEADER) {
            val binding = ItemChapterDetailsHeaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            HeaderVH(binding)
        } else {
            val binding = ItemVerseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            VerseVH(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is HeaderVH -> holder.bind(arabicName, englishName, hasBasmala())

            is VerseVH -> holder.bind(verses[position - 1], position - 1)
        }
    }

    // ================= HEADER =================
    class HeaderVH(private val binding: ItemChapterDetailsHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            arabic: String,
            english: String,
            showBasmala: Boolean
        ) {

            binding.chapterNameArabic.text = arabic
            binding.chapterNameEnglish.text = english

            binding.basmalaText.visibility =
                if (showBasmala) View.VISIBLE else View.GONE

            binding.iconBack.setOnClickListener {
                (binding.root.context as Activity).finish()
            }
        }
    }


    // ================= VERSE =================
    class VerseVH(private val binding: ItemVerseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(verse: String, position: Int) {
            binding.verse.text =
                "$verse ﴿${toArabicNumber(position + 1)}﴾"
        }

        private fun toArabicNumber(number: Int): String {
            return number.toString()
                .replace("0", "٠")
                .replace("1", "١")
                .replace("2", "٢")
                .replace("3", "٣")
                .replace("4", "٤")
                .replace("5", "٥")
                .replace("6", "٦")
                .replace("7", "٧")
                .replace("8", "٨")
                .replace("9", "٩")
        }
    }
}
