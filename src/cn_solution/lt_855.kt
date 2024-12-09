package cn_solution

import java.util.*

class ExamRoom(private val n: Int) {

    private val range = PriorityQueue<IntArray>(compareBy({
        when {
            it[0] == 0 || it[1] == n - 1 -> it[0] - it[1]
            else -> (it[0] - it[1]) / 2
        }
    }, { it[0] }))
    private val seats = TreeSet<Int>()

    init {
        range.add(intArrayOf(0, n - 1))
    }

    fun seat(): Int {
        do {
            val a = range.poll()
            val (s, e) = a
            val x = seats.ceiling(s)
            if (x == null || x > e) {
                val seat = when {
                    s == 0 -> 0
                    e == n - 1 -> n - 1
                    else -> (s + e) / 2
                }
                seats.add(seat)
                if (seat != s)
                    range.add(intArrayOf(s, seat - 1))
                if (seat != e)
                    range.add(intArrayOf(seat + 1, e))
                return seat
            }
        } while (true)
    }

    fun leave(p: Int) {
        seats.remove(p)
        val r = intArrayOf(p, p)
        val s = seats.lower(p) ?: -1
        if (s != p - 1)
            r[0] = s + 1
        val e = seats.higher(p) ?: n
        if (e != p + 1)
            r[1] = e - 1
        range.add(r)
    }
}