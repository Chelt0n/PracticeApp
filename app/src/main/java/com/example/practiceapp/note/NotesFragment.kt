package com.example.practiceapp.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practiceapp.R
import com.example.practiceapp.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private var binding: FragmentNotesBinding? = null

    lateinit var note: Notes
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        binding?.titleNotes?.text =(note.title + ":")
        binding?.notes?.setText(note.message)
        return binding?.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            note = requireArguments().getParcelable<Notes>(ARG_NAME)!!
        }
    }

    companion object {
        const val ARG_NAME = "nameOfNote"
        fun newInstance(notes: Notes): NotesFragment {
            val fragment = NotesFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_NAME, notes)
            fragment.arguments = bundle
            return fragment
        }
    }


}

