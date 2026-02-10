package com.example.islami.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterBinding
import com.example.islami.databinding.ItemQuranHeaderBinding

import models.ChapterDM


class ChaptersAdapter(val chapters: List<ChapterDM>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {

            TYPE_HEADER -> {
                val binding = ItemQuranHeaderBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            }

            else -> {
                val binding = ItemChapterBinding.inflate(inflater, parent, false)
                ChapterViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return chapters.size + 1 // +1 للـ Header
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ChapterViewHolder) {
            val chapter = chapters[position - 1] // -1 علشان ال Header
            holder.bind(chapter)
        }
    }

    class HeaderViewHolder(val binding: ItemQuranHeaderBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ChapterViewHolder(val binding: ItemChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chapterDM: ChapterDM) {
            binding.chapterLength.text = "${chapterDM.length} Verses"
            binding.chapterNameArabic.text = chapterDM.arabicName
            binding.chapterNameEnglish.text = chapterDM.englishName
            binding.chapterIndexTextView.text = chapterDM.index
        }
    }
}

//class ChaptersAdapter(val chapters: List<ChapterDM>? = null) :
//    RecyclerView.Adapter<ChaptersAdapter.ChapterViewHolder>() {
//    var onChapterClickListener: OnChapterClickListener? = null
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): ChapterViewHolder {
//        // 1 Recycler View Different View Types
//
//        val context = parent.context
//        val inflater = LayoutInflater.from(context)
//        val binding = ItemChapterBinding.inflate(inflater, parent, false)
//        return ChapterViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(
//        holder: ChapterViewHolder,
//        position: Int
//    ) {
//        val chapterDM = chapters?.get(position)
//        holder.binding.root.setOnClickListener {
//            if (chapterDM != null)
//                onChapterClickListener?.onChapterClick(chapterDM, position)
//        }
//        holder.bind(chapterDM, position)
//    }
//
//    override fun getItemCount(): Int {
////        if (chapters == null)
////            return 0
////        return chapters.size
//        return chapters?.size ?: 0
//    }
//
//
//    class ChapterViewHolder(val binding: ItemChapterBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(chapterDM: ChapterDM?, position: Int) {
//            binding.chapterLength.text = "${chapterDM?.length} Verses"
//            binding.chapterNameArabic.text = chapterDM?.arabicName
//            binding.chapterNameEnglish.text = chapterDM?.englishName
//            binding.chapterIndexTextView.text = chapterDM?.index
//        }
//    }
//}