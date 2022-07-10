package cn_offer

class MovingAverage(private val size: Int) {

    /** Initialize your data structure here. */
    private val q = ArrayDeque<Int>(size)
    private var sum = 0

    fun next(`val`: Int): Double {
        if (q.size == size)
            sum -= q.removeFirst()
        q.addLast(`val`)
        sum += `val`
        return sum.toDouble() / q.size
    }
}