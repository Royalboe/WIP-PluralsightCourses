package com.example.notekeeper


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*


class NoteListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)

// Describe the activity we want using the intent
// Pass the intent information from the notelist activity to the main activity
        fab.setOnClickListener {
            val activityIntent = Intent(this, MainActivity::class.java)
            // start the activity running
            startActivity(activityIntent)
        }
        listNotes.adapter = ArrayAdapter<NoteInfo>(
            this,
            android.R.layout.simple_list_item_1,
            DataManager.notes
        )


        // add the code that lets user note from the list and help them launch activity passing
        // about the note that was selected.
        // First thing is to add code that can listen when a user selects a note from the listview
        /* listNotes.setOnItemClickListener{ parent, view, position, id ->
             val activityIntent = Intent(this, MainActivity::class.java)
             activityIntent.putExtra(NOTE_POSITION, position)
             startActivity(activityIntent)
         }*/

    }

    override fun onResume() {
        super.onResume()
        //  (listNotes.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}