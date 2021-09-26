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
        var title:TextView? = view.findViewById(R.id.titleNotes)
        val titleArray = resources.getStringArray(R.array.title)
        title?.text = "Список заметок"
        var layout:LinearLayout = view.findViewById(R.id.titleLinear)

        for (i in titleArray.indices) {
            val name: String = titleArray[i]
            val textView = TextView(context)
            textView.text = name
            textView.textSize = 30f
            layout.addView(textView)
            var idNote:Int = i
            textView.setOnClickListener {
                showNote(idNote)

            }
        }

    }

    private fun showNote(idNote: Int) {
        var layoutId: Int = R.id.frame_note_title
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutId = R.id.frame_notes
        }
        val notesFragment = NotesFragment(idNote)
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(layoutId, notesFragment)
            .addToBackStack(NotesFragment::class.java.simpleName).commit()
    }

    companion object {
        fun newInstance() = TitleFragment()
    }


}