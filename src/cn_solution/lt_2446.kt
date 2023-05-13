package cn_solution

fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
    return event1[1] >= event2[0] && event2[1] >= event1[0]
}