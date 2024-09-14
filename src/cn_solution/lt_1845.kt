package cn_solution

import java.util.*

class SeatManager(n: Int) {

    private val idle = (1..n).toCollection(PriorityQueue())

    fun reserve(): Int {
        return idle.poll()
    }

    fun unreserve(seatNumber: Int) {
        idle.add(seatNumber)
    }
}