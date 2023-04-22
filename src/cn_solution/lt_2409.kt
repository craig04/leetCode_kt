package cn_solution

fun countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int {
    val days = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val sums = IntArray(13)
    days.forEachIndexed { i, day -> sums[i + 1] = sums[i] + day }
    fun String.toDay() = sums[substring(0, 2).toInt()] + substring(3).toInt()
    val leave = minOf(leaveAlice.toDay(), leaveBob.toDay())
    val arrive = maxOf(arriveAlice.toDay(), arriveBob.toDay())
    return maxOf(0, leave - arrive + 1)
}