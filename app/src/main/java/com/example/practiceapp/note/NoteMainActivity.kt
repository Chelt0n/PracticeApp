package com.example.practiceapp.note

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.practiceapp.MainActivity
import com.example.practiceapp.R

class NoteMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_activity)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_note_title, TitleFragment.newInstance()).commit()
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_notes, NotesFragment.newInstance(Notes("",""))).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        when(item.itemId){
            R.id.back -> startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}