package com.example.islami.fragments.hadeth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.fragments.hadeth.adepter.HadethAdapter
import com.example.islami.fragments.hadeth.model.Hadeth

class HadethFragment : Fragment() {

    private lateinit var binding: FragmentHadethBinding
    private lateinit var adapter: HadethAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HadethAdapter(readAhadethFile())



        binding.hadethListRecyclerView.adapter = adapter
    }

    private fun readAhadethFile(): List<Hadeth> {

        val content = requireContext()
            .assets
            .open("hadeth/ahadeth.txt")
            .bufferedReader()
            .use { it.readText() }

        val hadethBlocks = content.split("#")

        val hadethList = mutableListOf<Hadeth>()

        for (block in hadethBlocks) {

            val lines = block.trim().split("\n")

            if (lines.size > 1) {

                val title = lines[0].trim()

                val description = lines
                    .subList(1, lines.size)
                    .joinToString("\n")

                hadethList.add(
                    Hadeth(
                        title = title,
                        description = description
                    )
                )
            }
        }

        return hadethList
    }
}
