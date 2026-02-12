package com.example.islami.chapter_details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islami.databinding.ActivityChapterDetailsBinding
import com.route.islamic43gsunwed.chapterDetails.adapter.VersesAdapter

class ChapterDetailsActivity : AppCompatActivity() {

    private var index: Int? = null
    private var englishName: String? = null
    private var arabicName: String? = null

    private lateinit var binding: ActivityChapterDetailsBinding
    private lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initArguments()
        initializeVersesRecyclerView()
    }

    private fun initArguments() {
        englishName = intent.getStringExtra(ChapterDetailsKeys.englishName)
        arabicName = intent.getStringExtra(ChapterDetailsKeys.arabicName)
        index = intent.getIntExtra(ChapterDetailsKeys.index, 1)
        if (index == null || index!! < 1) {
            index = 1
        }
    }



    private fun initVersesList(): List<String> {
        val verses = assets.open("quran/$index.txt")
            .bufferedReader()
            .use { it.readLines() }

        return verses.filter { it.isNotBlank() }
    }

    private fun initializeVersesRecyclerView() {

        adapter = VersesAdapter(
            verses = initVersesList(),
            chapterIndex = index,
            arabicName = arabicName ?: "",
            englishName = englishName ?: ""
        )

        binding.versesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.versesRecyclerView.adapter = adapter

    }
}
