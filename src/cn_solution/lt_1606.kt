package cn_solution

fun busiestServers(k: Int, arrival: IntArray, load: IntArray): List<Int> {
    val cnt = IntArray(k)
    var max = 0
    val idle = (0 until k).toCollection(java.util.PriorityQueue())
    val busy = java.util.PriorityQueue<IntArray> { (a), (b) -> a - b }
    for (i in arrival.indices) {
        val t = arrival[i]
        while (busy.isNotEmpty() && busy.peek()[0] <= t) {
            val s = busy.poll()[1]
            idle += i + ((s - i) % k + k) % k
        }
        val s = idle.poll() ?: continue
        max = maxOf(max, ++cnt[s % k])
        busy += intArrayOf(arrival[i] + load[i], s % k)
    }
    return cnt.indices.filter { cnt[it] == max }
}