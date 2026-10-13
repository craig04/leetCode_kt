package cn_solution

class Solution_2409 {

    companion object {
        val sums = intArrayOf(
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        ).runningFold(0, Int::plus)
    }

    fun countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int {
        fun String.days() = sums[substring(0, 2).toInt() - 1] + substring(3).toInt()
        val arrive = maxOf(arriveAlice.days(), arriveBob.days())
        val leave = minOf(leaveAlice.days(), leaveBob.days())
        return maxOf(0, leave - arrive + 1)
    }
}