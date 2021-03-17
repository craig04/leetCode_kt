package solution

import kotlin.math.abs

/**
 * O(n) algorithm
 */
fun minOperations(boxes: String): IntArray {
    val ch = boxes.toCharArray()
    return IntArray(ch.size).apply {
        calc(ch, ch.indices)
        calc(ch, ch.size - 1 downTo 0)
    }
}

private fun IntArray.calc(boxes: CharArray, progression: IntProgression) {
    var balls = 0
    var moves = 0
    for (i in progression) {
        moves += balls
        this[i] += moves
        if (boxes[i] == '1') balls++
    }
}

/**
 * O(n*n) algorithm
 */
fun minOperations_2(boxes: String): IntArray {
    return IntArray(boxes.length) { i ->
        boxes.indices.sumBy {
            if (boxes[it] == '1') abs(it - i) else 0
        }
    }
}