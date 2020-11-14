package solution

import java.util.*

fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    val pq = PriorityQueue<Int>()
    var brickUsed = 0
    return (0 until heights.size - 1).firstOrNull {
        val diff = heights[it + 1] - heights[it]
        if (diff <= 0) {
            return@firstOrNull false
        }
        pq.add(diff)
        if (pq.size > ladders) {
            brickUsed += pq.poll()
        }
        brickUsed > bricks
    } ?: heights.size - 1
}