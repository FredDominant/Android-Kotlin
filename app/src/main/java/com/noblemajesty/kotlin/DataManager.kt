package com.noblemajesty.kotlin


object DataManager {

    val courses = HashMap<String, CourseInfo>()

    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo(title = "Android programming with Intents", courseId = "android intents")
        courses.set(course.courseId, course)

        course = CourseInfo("Android async", "Android programming async")
        courses.set(course.courseId, course)

        course = CourseInfo("Java Fundamental", "Java programming fundamentals")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "Kotlin Beginners", title = "Android programming in Kotlin for beginners")
        courses.set(course.courseId, course)
    }

    fun initializeNotes() {
        var noteInfo = NoteInfo(CourseInfo(title = "Android programming with Intents", courseId = "android intents"),
                title = "Programming with Intents",
                text = "A bunch of random texts")
        notes.add(noteInfo)

        noteInfo = NoteInfo(course = CourseInfo("Android async", "Android programming async"),
                title = "Javvvvvva fundamentals",
                text = "Java fundamentals texxxxxttt")
        notes.add(noteInfo)
//
        noteInfo = NoteInfo(CourseInfo(courseId = "Kotlin Beginners", title = "Android programming in Kotlin for beginners"),
                title = "Doing some other stuff",
                text = "A bunch of random texts")
        notes.add(noteInfo)
    }
}