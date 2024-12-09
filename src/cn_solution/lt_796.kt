package cn_solution

fun rotateString(s: String, goal: String): Boolean {
    return s.length == goal.length && goal in s + s
}