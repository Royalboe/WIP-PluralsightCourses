package com.example.notekeeper
// classes representing courses and notes in our app.

// create an override for the course info class toString() method so that it returns the course
// title which would be displayed by the adapter
data class CourseInfo(val courseId: String, val title: String) {

    override fun toString(): String {
        return title
    }
}

data class NoteInfo(var course: CourseInfo, var title: String, var text: String)

// create class that serves as source of management for instances of those classes which is the
// DataManager class
