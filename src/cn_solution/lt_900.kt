package cn_solution

class RLEIterator(private val encoding: IntArray) {

    private var i = 0
    private var j = 0

    fun next(n: Int): Int {
        var left = n
        while (i != encoding.size) {
            if (j + left > encoding[i]) {
                i += 2
                j = 0
                left -= encoding[i] - j
            } else {
                j += left
                println("$i, $j, res = ${encoding[i + 1]}")
                return encoding[i + 1]
            }
        }
        return -1
    }
}