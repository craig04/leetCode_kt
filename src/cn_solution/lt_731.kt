package cn_solution

class MyCalendarTwo() {

    private val schedules = ArrayList<Pair<Int, Int>>()
    private val overlaps = ArrayList<Pair<Int, Int>>()

    private fun Pair<Int, Int>.overlaps(start: Int, end: Int): Boolean {
        return second > start && first < end
    }

    fun book(start: Int, end: Int): Boolean {
        if (overlaps.any { it.overlaps(start, end) }) {
            return false
        }
        for (schedule in schedules) {
            val s = maxOf(schedule.first, start)
            val e = minOf(schedule.second, end)
            if (s < e) {
                overlaps.add(Pair(s, e))
            }
        }
        schedules.add(Pair(start, end))
        return true
    }
}