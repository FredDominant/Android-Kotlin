package com.noblemajesty.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var position : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        position = intent.getIntExtra(getString(R.string.position), 0)
        val adapterCourses = ArrayAdapter<CourseInfo>(this,
                android.R.layout.simple_spinner_item,
                DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spinner_select_course.adapter = adapterCourses

        displayNote()

    }


    private fun displayNote() {

        Log.e("Intent position", position.toString())

        val note = DataManager.notes.get(position)

        text_title.setText(note.text)
        text_content.setText(note.title)

        val dropdownPosition = DataManager.courses.values.indexOf(note.course)

        spinner_select_course.setSelection(dropdownPosition)
    }

    override fun onCreateOptionsMenu( menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            R.id.action_next -> {
                moveNext()
                return true
            }
            R.id.action_previous -> {
                movePrevious()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (position == (DataManager.notes.lastIndex)) {
            val nextMenu = menu?.findItem(R.id.action_next)
            nextMenu?.isVisible = false
        }

        if (position < 1) {
            val previousMenu = menu?.findItem(R.id.action_previous)
            previousMenu?.isVisible = false
        }

        return super.onPrepareOptionsMenu(menu)
    }

    private fun movePrevious() {
        if (position >= 1) {
            position --
            displayNote()
            invalidateOptionsMenu()
        }
    }

    private fun moveNext() {
        Log.e("Size", "${DataManager.notes.size}")
        Log.e("Position", "$position")
        if (position < (DataManager.notes.size - 1)) {
            position ++
            displayNote()
            invalidateOptionsMenu()
        }
    }
}
