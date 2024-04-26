package com.bimobelajar.simpledictionaryrev

import WordAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class wordFragment : Fragment() {
    private lateinit var wordRecyclerView: RecyclerView
    private val args: wordFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_word, container, false)
        wordRecyclerView = view.findViewById(R.id.wordRecyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val words = getWordsStartingWith(args.alphabet)

        val wordAdapter = WordAdapter(words) { word ->
            val searchUrl = "https://www.google.com/search?q=${word.value}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))
            startActivity(intent)
        }

        wordRecyclerView.adapter = wordAdapter
        wordRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getWordsStartingWith(alphabet: String?): List<wordData> {
        val wordList = mutableListOf<wordData>()

        when (alphabet) {
            "A" -> wordList.add(wordData("Apple"))
            "B" -> {
                wordList.add(wordData("Banana"))
                wordList.add(wordData("Bicycle"))
                wordList.add(wordData("Book"))
            }
            "C" -> wordList.add(wordData("Cat"))
            //TODO : lanjutin mapping word
            else -> {
                //TODO : Bikin toast error
            }
        }

        return wordList
    }

}