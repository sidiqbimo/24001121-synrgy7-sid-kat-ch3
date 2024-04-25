package com.bimobelajar.simpledictionaryrev

import AlphabetAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class alphabetFragment : Fragment() {
    private lateinit var alphabetRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alphabet, container, false)
        alphabetRecyclerView = view.findViewById(R.id.alphabetRecyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val alphabetList = ('A'..'Z').toList()

        val alphabetAdapter = AlphabetAdapter(alphabetList) { alphabet ->
            val action = FragmentAlphabetDirections.actionFragmentAlphabetToFragmentWord(alphabet)
            findNavController().navigate(action)
        }

        alphabetRecyclerView.adapter = alphabetAdapter
        alphabetRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}