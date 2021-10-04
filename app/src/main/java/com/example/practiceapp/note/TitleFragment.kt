package com.example.practiceapp.note

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment


import android.widget.LinearLayout
import android.widget.TextView

import com.example.practiceapp.R


class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleArray = resources.getStringArray(R.array.title)
        val notesArray = resources.getStringArray(R.array.notes)
        val layout: LinearLayout = view.findViewById(R.id.titleLinear)

        for (i in titleArray.indices) {
            val name: String = titleArray[i]
            val textView = TextView(context)
            textView.text = name
            textView.textSize = 30f
            layout.addView(textView)
            var idNote: Int = i
            var currentNotes = Notes(titleArray[idNote], notesArray[idNote])
            textView.setOnClickListener {
                showNote(currentNotes)
            }
        }

    }

    private fun showNote(currentNote: Notes) {
        var layoutId: Int = R.id.frame_note_title

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutId = R.id.frame_notes
        }

        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(layoutId, NotesFragment.newInstance(currentNote))
            .addToBackStack(NotesFragment::class.java.simpleName).commit()
    }

    companion object {
        fun newInstance() = TitleFragment()
    }


}