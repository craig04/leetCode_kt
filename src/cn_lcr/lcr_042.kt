package cn_lcr

class RecentCounter() {

    private val deque = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        deque.addLast(t)
        while (deque.first() < t - 3000)
            deque.removeFirst()
        return deque.size
    }
}