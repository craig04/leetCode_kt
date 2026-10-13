package cn_solution

fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
    val n = times.size
    val vacant = (0 until n).toCollection(java.util.PriorityQueue())
    val events = ArrayList<IntArray>()
    for (i in 0 until n) {
        val (arrive, leave) = times[i]
        events += intArrayOf(i, 0, arrive)
        events += intArrayOf(i, 1, leave)
    }
    val seats = IntArray(n)
    events.sortWith(compareBy({ it[2] }, { -it[1] }))
    for ((i, type) in events) {
        if (type == 0) {
            val s = vacant.poll()
            if (i == targetFriend)
                return s
            seats[i] = s
        } else {
            vacant += seats[i]
        }
    }
    return -1
}