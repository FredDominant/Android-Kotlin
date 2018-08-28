package com.noblemajesty.kotlin


class DataManager {

    val courses = HashMap<String, CourseInfo>()

    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
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
}