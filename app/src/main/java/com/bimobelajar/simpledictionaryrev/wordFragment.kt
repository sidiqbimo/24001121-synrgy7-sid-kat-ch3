package com.bimobelajar.simpledictionaryrev

import WordAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bimobelajar.simpledictionaryrev.R
import android.widget.TextView

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

        val headerTextView = view.findViewById<TextView>(R.id.headerTextView)
        val alphabet = args.alphabet
        val headerText = "Words Starting with $alphabet"
        headerTextView.text = headerText

        wordRecyclerView.adapter = wordAdapter
        wordRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun getWordsStartingWith(alphabet: String?): List<wordData> {
        val wordList = mutableListOf<wordData>()

        when (alphabet) {
            "A" -> {
                wordList.add(wordData("Apple"))
                wordList.add(wordData("Aeroplane"))
                wordList.add(wordData("Attire"))

            }
            "B" -> {
                wordList.add(wordData("Binar"))
                wordList.add(wordData("Bicycle"))
                wordList.add(wordData("Book"))
            }
            "C" -> {
                wordList.add(wordData("Cat"))
                wordList.add(wordData("Call"))
                wordList.add(wordData("Column"))
            }
            "D" -> {
                wordList.add(wordData("Deer"))
                wordList.add(wordData("Dare"))
                wordList.add(wordData("Dog"))
            }
            "E" -> {
                wordList.add(wordData("Elephant"))
                wordList.add(wordData("Earn"))
                wordList.add(wordData("Ear"))
            }
            "F" -> {
                wordList.add(wordData("Fan"))
                wordList.add(wordData("Fur"))
                wordList.add(wordData("Fist"))
            }
            "G" -> {
                wordList.add(wordData("Great"))
                wordList.add(wordData("Gold"))
                wordList.add(wordData("Golem"))
            }
            "H" -> {
                wordList.add(wordData("Hand"))
                wordList.add(wordData("Hard"))
                wordList.add(wordData("Hint"))
            }
            "I" -> {
                wordList.add(wordData("Intelligent"))
                wordList.add(wordData("Implement"))
                wordList.add(wordData("Irrational"))
            }
            "J" -> {
                wordList.add(wordData("Jeremy"))
                wordList.add(wordData("Josh"))
                wordList.add(wordData("Jane"))
            }
            "K" -> {
                wordList.add(wordData("Kate"))
                wordList.add(wordData("Kolin"))
                wordList.add(wordData("Khan"))
            }
            "L" -> {
                wordList.add(wordData("Lynn"))
                wordList.add(wordData("Leiden"))
                wordList.add(wordData("Lora"))
            }
            "M" -> {
                wordList.add(wordData("Michael"))
                wordList.add(wordData("Max"))
                wordList.add(wordData("Marry"))
            }
            "N" -> {
                wordList.add(wordData("Nolan"))
                wordList.add(wordData("Naufal"))
                wordList.add(wordData("Nanden"))
            }
            "O" -> {
                wordList.add(wordData("Oreo"))
                wordList.add(wordData("Ola"))
                wordList.add(wordData("Oki"))
            }
            "P" -> {
                wordList.add(wordData("Peter"))
                wordList.add(wordData("Parker"))
                wordList.add(wordData("Putra"))
            }
            "Q" -> {
                wordList.add(wordData("Question"))
                wordList.add(wordData("Quick"))
                wordList.add(wordData("Quiet"))
            }
            "R" -> {
                wordList.add(wordData("Raw"))
                wordList.add(wordData("Remove"))
                wordList.add(wordData("Range"))
            }
            "S" -> {
                wordList.add(wordData("Sulfur"))
                wordList.add(wordData("Sand"))
                wordList.add(wordData("Strict"))
            }
            "T" -> {
                wordList.add(wordData("Tame"))
                wordList.add(wordData("Tall"))
                wordList.add(wordData("Think"))
            }
            "U" -> {
                wordList.add(wordData("Uganda"))
                wordList.add(wordData("United"))
                wordList.add(wordData("Uruguay"))
            }
            "V" -> {
                wordList.add(wordData("Valentine"))
                wordList.add(wordData("Very"))
                wordList.add(wordData("Vase"))
            }
            "W" -> {
                wordList.add(wordData("War"))
                wordList.add(wordData("Where"))
                wordList.add(wordData("Wind"))
            }
            "X" -> {
                wordList.add(wordData("Xenoblade"))
                wordList.add(wordData("Xavier"))
                wordList.add(wordData("Xerox"))
            }
            "Y" -> {
                wordList.add(wordData("Yawn"))
                wordList.add(wordData("Yoyo"))
                wordList.add(wordData("Year"))
            }
            "Z" -> {
                wordList.add(wordData("Zathura"))
                wordList.add(wordData("Zimbabwe"))
                wordList.add(wordData("Zero"))
            }

            else -> {
                //TODO : Bikin toast error
            }
        }

        return wordList
    }

}