package cn_solution

fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
    val indices = Array(n) { it }
    indices.sortByDescending { efficiency[it] }
    var sum = 0L
    val q = java.util.PriorityQueue<Int>()
    return (indices.maxOf {
        val s = speed[it]
        if (q.size == k) {
            if (s <= q.peek())
                return@maxOf 0
            sum -= q.poll()
        }
        sum += s
        q.offer(s)
        sum * efficiency[it]
    } % 1000000007).toInt()
}