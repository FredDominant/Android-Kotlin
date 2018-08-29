package com.noblemajesty.kotlin

data class CourseInfo (val courseId: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

class NoteInfo (val course: CourseInfo, var title: String, var text: String) {
    override fun toString(): String {
        return title
    }
}