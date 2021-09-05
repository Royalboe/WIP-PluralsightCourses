package com.example.notekeeper

import kotlin.collections.set

// create class that serves as source of management for instances of the courseInfo
// and noteInfo classes
// It would not need a constructor but it would need properties to hold
// a collection of courses and notes

// Change our data manager from class to an object to easily interact with a single instance of
// of the datamanager

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()
    // code to initialize datamanager class
    // step one - Create functions that will create instances of the CourseInfo class and
    // and place them into the hashmap

    //Create initializer block and call the initializeCourses fxn, by doing this anytime an instance
    //of DataManager class is created the code within the initializer block runs automatically
    // which means we will automatically populate our collection of courses
    init {
        initializeCourses()
        initializeNotes()
    }


    private fun initializeCourses() {
        // create instances of courseinfo class
        var course = CourseInfo("android_intents", "Android Programming with Intents")

        // after creating the courseinfo instance we add it to our courses collection
        // and we can do that by setting our hashmap
        //courses.set(course.courseId,course) can be replaced with the indexing operator below
        courses[course.courseId] = course

        // assign the course variable a new courseinfo instance
        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses[course.courseId] = course

        // assign the course with a new variable
        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java lang")
        courses[course.courseId] = course

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)

    }

    private fun initializeNotes() {
        //create instances of noteinfo class
        var course = courses["android_intents"]!!
        var note = NoteInfo(
            course, "Dynamic intent resolution",
            "Wow, intents allow components to be resolved at runtime"
        )
        notes.add(note)
        note = NoteInfo(
            course, "Delegating intents",
            "PendingIntents are powerful; they delegate much more than just a component invocation"
        )
        notes.add(note)

        course = courses["android_async"]!!
        note = NoteInfo(
            course, "Service default threads",
            "Did you know that by default an Android Service will tie up the UI thread?"
        )
        notes.add(note)
        note = NoteInfo(
            course, "Long running operations",
            "Foreground Services can be tied to a notification icon"
        )
        notes.add(note)

        course = courses["java_lang"]!!
        note = NoteInfo(
            course, "Parameters",
            "Leverage variable-length parameter lists"
        )
        notes.add(note)
        note = NoteInfo(
            course, "Anonymous classes",
            "Anonymous classes simplify implementing one-use types"
        )
        notes.add(note)

        course = courses["java_core"]!!
        note = NoteInfo(
            course, "Compiler options",
            "The -jar option isn't compatible with with the -cp option"
        )
        notes.add(note)
        note = NoteInfo(
            course, "Serialization",
            "Remember to include SerialVersionUID to assure version compatibility"
        )
        notes.add(note)
    }


}