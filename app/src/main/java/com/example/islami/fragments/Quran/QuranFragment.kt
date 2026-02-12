package com.example.islami.fragments.Quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.chapter_details.ChapterDetailsActivity
import com.example.islami.chapter_details.ChapterDetailsKeys
import com.example.islami.fragments.Quran.adapter.ChaptersAdapter
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.fragments.Quran.adapter.OnChapterClickListener
import com.example.islami.fragments.Quran.model.ChapterDM

class QuranFragment : Fragment() {
    private lateinit var binding: FragmentQuranBinding
    private lateinit var adapter: ChaptersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChaptersRecyclerView()
    }

    private fun initChaptersRecyclerView() {

        adapter = ChaptersAdapter(ChapterDM.Companion.getChaptersList())
        binding.surasRecyclerView.adapter = adapter
        adapter.onChapterClickListener = object : OnChapterClickListener {
            override fun onChapterClick(
                chapterDM: ChapterDM,
                position: Int
            ) {
                if (context != null) {
                    val intent = Intent(context, ChapterDetailsActivity::class.java)
                    intent.putExtra(ChapterDetailsKeys.englishName, chapterDM.englishName)
                    intent.putExtra(ChapterDetailsKeys.arabicName, chapterDM.arabicName)
                    intent.putExtra(ChapterDetailsKeys.index, chapterDM.index)
                    startActivity(intent)
                }
            }

        }

    }

}