package cn_solution

class Router(private val memoryLimit: Int) {

    private class Destination {
        val q = ArrayDeque<IntArray>()
        val set = HashSet<Long>()
    }

    private val empty = IntArray(0)
    private val q = ArrayDeque<IntArray>()
    private val map = HashMap<Int, Destination>()

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val key = timestamp * 200001L + source
        if (map[destination]?.set?.contains(key) == true)
            return false
        if (q.size == memoryLimit)
            forwardPacket()
        val packet = intArrayOf(source, destination, timestamp)
        q.addLast(packet)
        map.computeIfAbsent(destination) { Destination() }.apply {
            q.addLast(packet)
            set.add(key)
        }
        return true
    }

    fun forwardPacket(): IntArray {
        if (q.isEmpty())
            return empty
        val packet = q.removeFirst()
        val (src, dst, ts) = packet
        map[dst]?.apply {
            q.removeFirst()
            set.remove(ts * 200001L + src)
        }
        return packet
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        fun ArrayDeque<IntArray>.ceiling(x: Int): Int {
            var l = 0
            var r = size
            while (l != r) {
                val m = (l + r) shr 1
                if (get(m)[2] < x)
                    l = m + 1
                else
                    r = m
            }
            return l
        }
        return map[destination]?.let {
            val l = it.q.ceiling(startTime)
            val r = it.q.ceiling(endTime + 1)
            r - l
        } ?: 0
    }
}