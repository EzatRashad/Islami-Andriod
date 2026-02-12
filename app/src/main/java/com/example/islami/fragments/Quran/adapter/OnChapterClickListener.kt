package com.example.islami.fragments.Quran.adapter

import com.example.islami.fragments.Quran.model.ChapterDM


interface OnChapterClickListener {
    fun onChapterClick(chapterDM: ChapterDM, position: Int)
}
