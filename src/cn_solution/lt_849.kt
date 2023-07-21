package cn_solution

fun maxDistToClosest(seats: IntArray): Int {
    var last = seats.indexOfFirst { it == 1 }
    var result = last
    for (i in last + 1 until seats.size) {
        if (seats[i] == 1) {
            result = maxOf(result, (i - last) shr 1)
            last = i
        }
    }
    return maxOf(result, (seats.lastIndex - last))
}