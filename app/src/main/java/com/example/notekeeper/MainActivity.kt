package com.example.notekeeper


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET

    // UI initialization is done in the onCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //Use the adaptor to populate the spinner with courses from datamanager class
        // val dm = DataManager() remove this and change dm to datamanager because it is no
        // longer a class

        // context is used to indicate the creation state of certain type of android classes
        // adapter classes help to populate our spinner with data and also handle the formatting of
        // the spinner current selection layout and the dropdown layout. So we create a new instance
        // of the adapter class to associate it with the spinner.
        val adapterCourses = ArrayAdapter<CourseInfo>(
            this,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList()
        )
        // To format dropdown selections
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // associate adapter with spinner to populate the spinner. To do this we will assign the
        // adapter created to the spinners adapter property
        spinnerCourses.adapter = adapterCourses
        notePosition =
            savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET) ?: intent.getIntExtra(
                NOTE_POSITION,
                POSITION_NOT_SET
            )

        if (notePosition != POSITION_NOT_SET)
            displayNote()
        else {
            DataManager.notes.add(NoteInfo())
            notePosition = DataManager.notes.lastIndex
        }
    }

    // To save instance state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NOTE_POSITION, notePosition)
    }

    private fun displayNote() {
        if(notePosition > DataManager.notes.lastIndex) {
            showMessage("Note Not Found")
            return
        }
        val note = DataManager.notes[notePosition]
        // edit text display text and lets users interact with the text, but text property type is
        // not string, it is editable, so instead of using the string value we use setText
        textNoteTitle.setText(note.title)
        textNoteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        spinnerCourses.setSelection(coursePosition)
    }

    // This is to inflate the menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val message = "No More Notes"
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_next -> {
                if (notePosition < DataManager.notes.lastIndex) {
                    moveNext()
                } else {
                    showMessage(message)
                }
                true
            }
            R.id.action_previous -> {
                if (notePosition > FIRST_NOTE) {
                    showPrevious()
                } else {
                    showMessage(message)
                }
                true

            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(textNoteTitle, message, Snackbar.LENGTH_LONG).show()
    }

    private fun showPrevious() {
        --notePosition
        displayNote()
        invalidateOptionsMenu()
    }

    private fun moveNext() {
        ++notePosition
        displayNote()
        // this used to make changes to menu that has being displayed and when it gets called,
        // it calls the onPrepareOptionsMenu
        invalidateOptionsMenu()
    }

    // used to make changes to menuItem at runtime, it is called before the menu is initially
    // displayed, before being called by the invalidateOptionsMenu() to effect changes
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (notePosition >= DataManager.notes.lastIndex) {
            val menuItem = menu?.findItem(R.id.action_next)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_block_black_24dp)
                menuItem.isEnabled = true
            }
        } else if (notePosition <= 0) {
            val menuItem = menu?.findItem(R.id.action_previous)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_block_black_24dp)
                menuItem.isEnabled = true
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    // The best time to automatically save changes to an activity is when the activity stops being visible
    // this happens at the onPause method in the activity lifecycle
    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        // select note position property to currently displayed notes from our datamanager
        val note = DataManager.notes[notePosition]
        note.title = textNoteTitle.text.toString()
        note.text = textNoteText.text.toString()
        note.course = spinnerCourses.selectedItem as CourseInfo

    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}