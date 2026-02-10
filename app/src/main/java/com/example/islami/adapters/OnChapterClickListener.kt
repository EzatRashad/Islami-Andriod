package com.example.islami.adapters

import models.ChapterDM


interface OnChapterClickListener {
    fun onChapterClick(chapterDM: ChapterDM, position: Int)
}
