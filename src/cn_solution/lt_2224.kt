package cn_solution

fun convertTime(current: String, correct: String): Int {
    fun String.currentTime() = substring(0, 2).toInt() * 60 + substring(3).toInt()
    var gap = correct.currentTime() - current.currentTime()
    var ans = 0
    for (inc in intArrayOf(60, 15, 5, 1)) {
        ans += gap / inc
        gap %= inc
    }
    return ans
}