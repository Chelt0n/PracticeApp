package com.example.practiceapp.note

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiceapp.R

class NoteMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_main_activity)


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_note_title, TitleFragment.newInstance()).commit()
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_notes, NotesFragment.newInstance(Notes("ss","ss"))).commit()
        }
    }
}